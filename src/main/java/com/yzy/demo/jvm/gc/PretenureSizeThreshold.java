package com.yzy.demo.jvm.gc;

import static com.yzy.demo.jvm.gc.AllocationTest._1MB;

/**
 * 测试大对象直接分配到老年代
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
 * @author yangzyh
 * @date 2023/1/6 16:48
 */
public class PretenureSizeThreshold {
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
