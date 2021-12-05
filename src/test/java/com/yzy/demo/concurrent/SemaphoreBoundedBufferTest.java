package com.yzy.demo.concurrent;

import org.junit.Test;

import static org.junit.Assert.*;

public class SemaphoreBoundedBufferTest {
    private static final int LOCKUP_DETECT_TIMEOUT = 1000;

    @Test
    public void testIsEmptyWhenConstructed() {
        SemaphoreBoundedBuffer<Integer> buffer = new SemaphoreBoundedBuffer<>(10);
        assertTrue(buffer.isEmpty());
        assertFalse(buffer.isFull());
    }

    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        SemaphoreBoundedBuffer<Integer> buffer = new SemaphoreBoundedBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            buffer.put(i);
        }
        assertTrue(buffer.isFull());
    }

    @Test
    public void testTakeBlocksWhenEmpty() {
        final SemaphoreBoundedBuffer<Integer> buffer = new SemaphoreBoundedBuffer<>(10);
        Thread taker = new Thread(()->{
            try {
                buffer.take();
                fail();
            } catch (InterruptedException success) {
            }
        });
        try {
            taker.start();
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            taker.interrupt();
            taker.join(LOCKUP_DETECT_TIMEOUT);
            assertFalse(taker.isAlive());
        } catch (Exception e) {
            fail();
        }
    }
}