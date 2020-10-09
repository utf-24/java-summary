package com.yzy.demo.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * cache 全局类
 *
 * @author yangzyh
 * @date 2020/10/9 18:24
 */
public class CacheGlobal {
    public static final ConcurrentMap<String, MyCache> cacheMap = new ConcurrentHashMap<>();
}
