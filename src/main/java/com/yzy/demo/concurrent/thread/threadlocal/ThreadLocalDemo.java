package com.yzy.demo.concurrent.thread.threadlocal;

import java.lang.reflect.Field;

/**
 * 验证gc后 Thread里的ThreadLocalMap 的key(指向如果有ThreadLocal的弱引用)是否为null
 * 如果有ThreadLocal的强引用，则key不为null，否则为null
 * @author yangzyh
 * @date 2023/2/10 15:27
 */

public class ThreadLocalDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Thread t = new Thread(()->test("abc",false));
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }

    private static void test(String s,boolean isGC)  {
        try {
            //有threadLocal 强引用，所以gc后 ThreadLocalMap的key不会为null
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            threadLocal.set(s);
            //没有threadLocal 强引用，所以gc后 ThreadLocalMap的key会为null
            //new ThreadLocal<>().set(s);
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object ThreadLocalMap = field.get(t);
            Class<?> tlmClass = ThreadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(ThreadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//------
//        著作权归所有
//        原文链接：https://javaguide.cn/java/concurrent/threadlocal.html