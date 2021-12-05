package com.yzy.demo.concurrent;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SemaphoreBoundedBufferTest {

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
}