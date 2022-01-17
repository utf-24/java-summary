package com.yzy.demo.algorithm;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangzyh
 * @date 2020/10/27 16:05
 */
public class LruDemo<k,v> extends LinkedHashMap<k,v> {
    private int maxCapacity;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Lock lock = new ReentrantLock();

    public LruDemo(int maxCapacity) {
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return size() > maxCapacity;
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        try {
            return super.containsKey(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public v get(Object key) {
        lock.lock();
        try {
            return super.get(key);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public v put(k key, v value) {
        lock.lock();
        try {
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        lock.lock();
        try {
            super.clear();
        } finally {
            lock.unlock();
        }
    }

    public Collection<Map.Entry<k, v>> getAll() {
        lock.lock();
        try {
            return new ArrayList<Map.Entry<k, v>>(super.entrySet());
        } finally {
            lock.unlock();
        }
    }

    /**
     * 牛客网lru算法
     * @param operators
     * @param k
     * @return
     */
    public int[] LRU (int[][] operators, int k) {
        List<Integer> result = new ArrayList<>();
        if(operators== null || operators.length == 0) {
            return new int[0];
        }
        LruDemo lruDemo = new LruDemo(k);
        for (int i = 0; i < operators.length ; i++) {
            int[] operator = operators[i];
            if(operator[0] == 1) {
                //写缓存
                lruDemo.put(operator[1], operator[2]);
            } else if (operator[0] == 2) {
                // 读缓存
              int value = (int) Optional.ofNullable(lruDemo.get(operator[1])).orElse(-1);
              result.add(value);
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return  resultArray;
    }
    public static void main(String[] args) {
        //int[][] operators ={{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        //int k = 3;
        //LruDemo lruDemo = new LruDemo(10);
        //int[] result = lruDemo.LRU(operators, k);
        //for (int i = 0; i < result.length; i++) {
        //    System.out.print(result[i]);
        //    System.out.print(" ");
        //}
        LruDemo lruDemo = new LruDemo(10);
        for(int i=0; i< 17; i++) {
            lruDemo.put(i,i);
        }
        lruDemo.get(8);
        System.out.println(lruDemo);
    }
}
