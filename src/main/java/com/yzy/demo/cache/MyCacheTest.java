package com.yzy.demo.cache;

/**
 * 缓存测试类
 *
 * @author yangzyh
 * @date 2020/10/9 18:46
 */
public class MyCacheTest {
    public static void main(String[] args) {
        CacheUtils cacheUtils = new CacheUtils();
        cacheUtils.put("kobe","bryant", 24);
        String val = (String) cacheUtils.get("kobe");
        System.out.println(val);
        System.out.println("get a cache don't exist: " + cacheUtils.get("lebron"));
    }
}
