package com.yzy.demo.cache;

import java.util.concurrent.TimeUnit;

/**
 * 过期缓存检测线程
 *
 * @author yangzyh
 * @date 2020/10/9 18:25
 */
public class ExpireThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(10);
                // 缓存检测和清除
                expireCache();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void expireCache() {
        System.out.println("检测缓存是否过期");
        for(String key: CacheGlobal.cacheMap.keySet()) {
            MyCache cache = CacheGlobal.cacheMap.get(key);
            long timeout = System.currentTimeMillis() - cache.getWriteTime();
            if(cache.getExpireTime() > timeout) {
                // 没过期
                continue;
            }
            CacheGlobal.cacheMap.remove(key);
        }
    }
}
