package com.yzy.demo.concurrent.tool;

import java.util.concurrent.Semaphore;

/**
 * 模拟三个服务窗口安检，多个线程排队
 *
 * @author young
 * @date 2020/1/20 23:01
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 三个服务窗口
        Semaphore semaphore = new Semaphore(3);
        // 五个人排队
        for(int i=0; i<5; i++) {
            new SecurityCheckThread(semaphore,i).start();
        }
    }

    static class SecurityCheckThread extends Thread {
        private Semaphore semaphore;
        private int seq;
        public SecurityCheckThread(Semaphore semaphore, int seq) {
            this.semaphore = semaphore;
            this.seq =seq;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("no." +seq + " is checking..");

                if(seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("no."+seq + " is suspicious, stopping");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
                System.out.println("no."+seq + " has finished");
            }

        }
    }

}
