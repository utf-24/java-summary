package com.yzy.demo.lock;

/**
 * 测试死锁
 *
 * @author young
 * @date 2019/8/11 9:21
 */
public class DeadLock {
    private static String A = "a";
    private static String B = "b";

    private void deadlock(){
        Thread t1 = new Thread(()->{
           synchronized (A){
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (B){
                   System.out.println("1");
               }
           }
        });

       Thread t2 = new Thread(()->{
           synchronized (B){
               synchronized (A){
                   System.out.println("2");
               }
           }
        });
        t1.start();
        t2.start();

    }

    public static void main(String[] args) {
        new DeadLock().deadlock();
    }
}
