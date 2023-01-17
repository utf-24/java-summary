package com.yzy.demo.concurrent;

/**
 * get set方法都设置为synchronized, 同一个对象，当set执行时，get会被阻塞，直到set执行完毕
 * @author yangzyh
 * @date 2023/1/17 10:09
 */
public class SynchronizedTest {
    private int value = 0;

    synchronized public int getValue() {
        return value;
    }

    synchronized public void setValue(int value) throws InterruptedException {
        Thread.sleep(3000);
        this.value = value;
    }

    public static void main(String[] args) {
        SynchronizedTest obj = new SynchronizedTest();
        Thread threadA = new Thread(()->{
            System.out.println("start set val");
            try {
                obj.setValue(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadB = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("start get val");
            System.out.println("get val: " + obj.getValue());
        });

        threadA.start();
        threadB.start();
    }
}
