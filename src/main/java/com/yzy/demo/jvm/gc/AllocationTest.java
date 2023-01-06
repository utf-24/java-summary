package com.yzy.demo.jvm.gc;

/**
 * 测试对象分配，新生代10m，survivor 8m
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 *
 * @author young
 * @date 2020/2/15 17:40
 */
public class AllocationTest {
    public static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];

        // 出现一次 Minor gc
        //allocation4 直接分配到老年代了
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
