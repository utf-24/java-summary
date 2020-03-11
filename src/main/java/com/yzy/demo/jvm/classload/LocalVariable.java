package com.yzy.demo.jvm.classload;

/**
 * 局部变量表的 变量槽slot复用测试
 * -verbose:gc
 * 《深入理解java虚拟机》p240
 * @author young
 * @date 2020/2/17 21:51
 */
public class LocalVariable {

    public static void main(String[] args) {
        // case 1 不会回收slot
//        byte[] placeholder = new byte[64 * 1024 * 1024];
//        System.gc();
//
        // case 2 不会回收slot
//        {
//            byte[] placeholder = new byte[64 * 1024 * 1024];
//        }
//        System.gc();

        // case3 会回收 slot,因为定义a变量了，复用了slot，之前失效的引用被清除
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
