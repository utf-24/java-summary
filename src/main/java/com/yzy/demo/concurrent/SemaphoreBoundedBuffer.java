package com.yzy.demo.concurrent;


import java.util.concurrent.Semaphore;

/**
 * BoundedBuffer
 * <p/>
 * Bounded buffer using \Semaphore
 *
 * @author Brian Goetz and Tim Peierls
 */
public class SemaphoreBoundedBuffer<E> {
    private final Semaphore availableItems, availableSpaces;
    private final E[] items;
    private int putPosition =0, takePosition = 0;

    public SemaphoreBoundedBuffer(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException();
        }
        items = (E[]) new Object[capacity];
        availableItems = new Semaphore(0);
        availableSpaces = new Semaphore(capacity);
    }

    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull() {
        return availableSpaces.availablePermits() == 0;
    }

    public void put(E x) throws InterruptedException {
        availableSpaces.acquire();
        doInsert(x);
        availableItems.release();
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = doExtract();
        availableSpaces.release();
        return item;
    }

    private synchronized E doExtract() {
        int i = takePosition;
        E x = items[takePosition];
        items[i] = null;
        takePosition = (++i == items.length) ? 0:i;
        return x;
    }

    private synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0: i;
    }

    public static void main(String[] args) {
        SemaphoreBoundedBuffer<Integer> s = new SemaphoreBoundedBuffer<>(10);
        new Thread(()->{
            System.out.println(Thread.currentThread() + "start...");
            Integer i = null;
            try {
                 i = s.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "take " + i);
        }).start();

        new Thread(()->{
            System.out.println(Thread.currentThread() + "start...");
            try {
                s.put(24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " finished");
        }).start();
    }
}
