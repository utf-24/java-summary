package com.yzy.demo.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
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

    public static void main(String[] args) {
        LruDemo lruDemo = new LruDemo(10);
        for(int i=0; i< 17; i++) {
            lruDemo.put(i,i);
        }
        lruDemo.get(12);
        System.out.println(lruDemo);
    }
}
