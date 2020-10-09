package com.yzy.demo.cache;

import org.apache.commons.lang.StringUtils;

/**
 * 缓存工具类
 *
 * @author yangzyh
 * @date 2020/10/9 18:31
 */
public class CacheUtils {

    public void put(String key, String value, long expire) {
        if(StringUtils.isBlank(key)) return;

        // 当缓存存在时，更新缓存
        if(CacheGlobal.cacheMap.containsKey(key)) {
            MyCache cache = CacheGlobal.cacheMap.get(key);
            cache.setHitCount(cache.getHitCount() + 1);
            cache.setWriteTime(System.currentTimeMillis());
            cache.setLastTime(System.currentTimeMillis());
            cache.setExpireTime(expire);
            cache.setValue(value);
            return;
        }

        // 缓存不存在，创建缓存
        MyCache cache = new MyCache();
        cache.setKey(key);
        cache.setValue(value);
        cache.setWriteTime(System.currentTimeMillis());
        cache.setLastTime(System.currentTimeMillis());
        cache.setExpireTime(expire);
        cache.setHitCount(1);
        CacheGlobal.cacheMap.put(key, cache);
    }

    public Object get(String key) {
        if(StringUtils.isBlank(key)) return null;
        if(CacheGlobal.cacheMap.isEmpty()) return null;
        if(!CacheGlobal.cacheMap.containsKey(key)) return null;
        MyCache cache = CacheGlobal.cacheMap.get(key);
        if(cache == null) return null;
        // 惰性删除
        long timeout = System.currentTimeMillis() - cache.getWriteTime();
        if(timeout > cache.getExpireTime()) {
            CacheGlobal.cacheMap.remove(key);
            return null;
        }
        cache.setHitCount(cache.getHitCount() + 1);
        cache.setLastTime(System.currentTimeMillis());
        return cache.getValue();
    }
}
