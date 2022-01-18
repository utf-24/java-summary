package com.yzy.demo.algorithm.structure.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 优先级队列
 * @author yangzyh
 * @date 2022/1/18 15:52
 */
public class MaxPQ<Key> implements Iterable<Key> {

    /**
     * storing items at indices 1 to n
     */
    private Key[] pq;

    /**
     * numbers of items in priority queue
     */
    private int n;

    private Comparator <Key> comparator;

    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
    }

    public MaxPQ() {
        this(1);
    }

    public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
    }

    public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[n +1];
        for (int i = 1; i < pq.length; i++) {
            pq[i] = keys[i-1];
        }
        for (int k = n/2; k >=1 ; k--) {
            // 为啥要从n/2开始下沉
            sink(k);
        }
    }

    private boolean isEmpty() {
        return n == 0;
    }

    private int size() {
        return n;
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("priority queue is empty!");
        }
        return pq[1];
    }

    public void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity + 1];
        for (int i = 1; i < pq.length; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key key) {
        if (n == pq.length-1) {
            resize(n*2);
        }
        pq[++n] = key;
        swim(n);
        assert isMaxHeap();
    }

    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty queue!");
        }
        Key max = pq[1];
        exchange(1, n--);
        pq[n+1] = null;
        sink(1);
        if ((n > 0) && (n == (pq.length-1)/4)) {
            //必要时减小数组
            resize(pq.length / 2);
        }
        assert isMaxHeap();
        return max;
    }


    private boolean isMaxHeap() {
        for (int i = 1; i < n; i++) {
            if (pq[i] == null) {
                return false;
            }
        }
        for (int i = n+1; i < pq.length; i++) {
            if(pq[i] != null) {
                return false;
            }
        }

        return isMaxHeapSorted(1);
    }

    private boolean isMaxHeapSorted(int i) {
        if (i > n) {
            return true;
        }
        int left = i*2;
        int right = i*2 + 1;
        if (left <=n && less(i, left)) {
            return false;
        }
        if (right <=n && less(i, right)) {
            return false;
        }

        return isMaxHeapSorted(left) && isMaxHeapSorted(right);
    }

    /**
     * 较大的元素上浮
     * @param key
     */
    private void swim(int i) {
        while (i > 1 && less(i/2, i)) {
            exchange(i/2,i);
            i = i/2;
        }
    }

    /**
     * 小元素下沉
     * @param k
     */
    private void sink(int k) {
        while (k*2 <= n) {
            int j = k*2;
            if(j < n && less(j,j+1)) {
                //最大堆并不能保证同一个节点的左子树是否比右子树大，所以要判断j和j+1的大小
                j++;
            }
            if(!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    private void exchange(int k, int i) {
        Key swap = pq[k];
        pq[k] = pq[i];
        pq[i] = swap;
    }

    private boolean less(int k, int i) {
        if (comparator == null) {
            return ((Comparable<Key>)pq[k]).compareTo(pq[i]) < 0;
        } else  {
            return comparator.compare(pq[k], pq[i]) < 0;
        }
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        // create a new pq
        private MaxPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) copy = new MaxPQ<Key>(size());
            else                    copy = new MaxPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }
}
