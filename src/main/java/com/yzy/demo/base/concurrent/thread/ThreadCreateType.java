package com.yzy.demo.base.concurrent.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程创建方式
 *
 * @author young
 * @date 2019/8/6 10:12
 */
public class ThreadCreateType {

    /**
     * 继承thread方式
     */
    static class InheritThread extends Thread{
        @Override
        public void run(){
            System.out.println("create type [inherit thread] +thread: "
                    + Thread.currentThread().getName());
        }
    }

    /**
     * 实现Runnable接口方式
     */
    static class ImplRunnableThread implements Runnable{

        @Override
        public void run() {
            System.out.println("create type [impl runnable] +thread: "
                    + Thread.currentThread().getName());
        }
    }

    /**
     * executorservice 方式创建线程
     */
    private void ExecutorServiceType() throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future> futureList = new ArrayList<>();
        for(int i = 0; i< 10;i ++) {
            int finalI = i;
            Callable task = () ->{
                System.out.println("callable: "+finalI);
                return finalI;
            };
            Future future = pool.submit(task);
            futureList.add(future);
        }
        pool.shutdown();
        futureList.forEach(i->{
            try {
                System.out.printf("res: %s%n", i.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("time: "+(end-start));
    }

    public static void main(String[] args) throws InterruptedException {
        InheritThread thread = new InheritThread();
        thread.start();

        ImplRunnableThread implRunnableThread = new ImplRunnableThread();
        Thread thread1 = new Thread(implRunnableThread);
        thread1.start();

        ThreadCreateType type = new ThreadCreateType();
        type.ExecutorServiceType();
    }
}
