package com.yzy.demo.cache;

import lombok.Data;

/**
 * 自定义缓存实体类
 *
 * @author yangzyh
 * @date 2020/10/9 18:20
 */
@Data
public class MyCache implements Comparable<MyCache> {

    private Object key;

    private Object value;

    /**
     * 最后访问时间
     */
    private long lastTime;

    /**
     * 创建时间
     */
    private long writeTime;

    private long expireTime;

    /**
     * 缓存命中次数
     */
    private Integer hitCount;

    @Override
    public int compareTo(MyCache o) {
        return hitCount.compareTo(o.hitCount);
    }
}
