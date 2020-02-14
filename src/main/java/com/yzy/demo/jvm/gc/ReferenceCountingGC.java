package com.yzy.demo.jvm.gc;

/**
 * -XX:+PrintGC
 *
 * @author young
 * @date 2019/6/6 16:03
 */
public class ReferenceCountingGC {
    public Object instance = null;
    public static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];

    public static void testGC(){
        ReferenceCountingGC objectA = new ReferenceCountingGC();
        ReferenceCountingGC objectB = new ReferenceCountingGC();
        objectA.instance = objectB;
        objectB.instance = objectA;
        objectA = null;
        objectB = null;
        System.gc();

    }
    public static void main(String[] args) {
        testGC();
    }
}
