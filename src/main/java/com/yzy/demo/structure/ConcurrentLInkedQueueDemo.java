package com.yzy.demo.structure;

import com.yzy.demo.util.SleepUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author young
 * @date 2019/9/26 10:27
 */
public class ConcurrentLInkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
//        new Thread(() -> {
//            queue.offer(1);
//            System.out.println("1 after offer");
//        }).start();
//        new Thread(() -> {
//            queue.offer(2);
//            System.out.println("2 after offer");
//        }).start();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.size());
    }
}
