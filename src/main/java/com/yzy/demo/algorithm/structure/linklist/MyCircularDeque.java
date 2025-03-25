package com.yzy.demo.algorithm.structure.linklist;

public class MyCircularDeque {
    class DListNode {
        int val;
        DListNode next = null;
        DListNode prev = null;
        public DListNode(int val) {
            this.val = val;
        }

        public DListNode(int val, DListNode next, DListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private int maxSize;
    private int count;
    private DListNode head;
    private DListNode tail;

    public MyCircularDeque(int k) {
        this.maxSize = k;
        this.count = 0;
        head = null;
        tail = null;
    }
    
    public boolean insertFront(int value) {
        if (count == maxSize) return false;
        DListNode node = new DListNode(value);
        if (count == 0) {
            tail = head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (count == maxSize) return false;
        DListNode node = new DListNode(value);
        if (count == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if (count == 0) return false;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if (count == 0) return false;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        count--;
        return true;
    }
    
    public int getFront() {
        if (count == 0) return -1;
        return head.val;
    }
    
    public int getRear() {
        if (count == 0) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */