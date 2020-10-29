package com.yzy.demo.base.lock;

import com.yzy.demo.concurrent.thread.pool.UserThreadFactory;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yangzyh
 * @date 2020/10/29 16:49
 */
public class ReentrantDistributedLock {
    private ThreadLocal<Map<String, Integer>> locks =  ThreadLocal.withInitial(HashMap::new);
    private Jedis jedis;

    public ReentrantDistributedLock(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean lock(String key) {
        int lockRefCount = getLockRefCount(key);
        if (lockRefCount > 0) {
            // 重入
            locks.get().put(key,++lockRefCount);
            return true;
        } else if ( doLock(key)) {
            locks.get().put(key, 1);
            return true;
        }

        return false;
    }

    public boolean unlock(String key) {
        int lockRefCount = getLockRefCount(key);
        if(lockRefCount > 0) {
            locks.get().put(key, --lockRefCount);
            if (lockRefCount <=0 ) {
                locks.get().remove(key);
                return doUnlock(key);
            }
        }
        return false;
    }

    private boolean doLock(String key) {
        String result = jedis.set(key, Thread.currentThread().getName(),"nx","ex",10);
        return result != null;
    }

    private boolean doUnlock(String key) {
        long result = jedis.del(key);
        return result > 0;
    }

    private int getLockRefCount(String key) { ;
        return locks.get().getOrDefault(key,0);
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.100", 6379);
        jedis.connect();
        ReentrantDistributedLock lock = new ReentrantDistributedLock(jedis);
        System.out.println("lock: " + lock.lock("demo"));
        System.out.println("lock: " + lock.lock("demo"));
        System.out.println("unlock: " + lock.unlock("demo"));
        System.out.println("unlock: " + lock.unlock("demo"));
        //ExecutorService executorService = Executors.newFixedThreadPool(5, new UserThreadFactory("distributed_lock"));
        //List<Future> results = new ArrayList<>();
        //for(int i = 0 ; i < 5; i++) {
        //    Future result = executorService.submit(()->{
        //        Jedis jedis = new Jedis("192.168.99.100", 6379);
        //        jedis.connect();
        //        ReentrantDistributedLock lock = new ReentrantDistributedLock(jedis);
        //        System.out.println(Thread.currentThread() +"try lock: " + lock.lock("young"));
        //        System.out.println(Thread.currentThread() +"try unlock: " + lock.unlock("young"));
        //    });
        //    results.add(result);
        //}
        //results.forEach(result->{
        //    try {
        //        result.get();
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    } catch (ExecutionException e) {
        //        e.printStackTrace();
        //    }
        //});
        //
        //System.out.println("finished");
    }
}
