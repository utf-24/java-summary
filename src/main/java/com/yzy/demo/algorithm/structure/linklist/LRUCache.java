package com.yzy.demo.algorithm.structure.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/lru-cache/
 * 使用hash 和 双链表实现 LRU
 *
 * @author yangzyh
 * @date 2023/1/27 21:36
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, DLinkNode> cache;
    DLinkNode dummyHead;
    DLinkNode dummyTail;

    class DLinkNode {
        DLinkNode prev;
        DLinkNode next;
        int key;
        int val;
        DLinkNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        dummyHead = new DLinkNode(-1, -1);
        dummyTail = new DLinkNode(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
    }

    /**
     * 如果存在，需要把节点移动到头部
     *
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkNode obj = cache.get(key);
        if (obj == null) {
            return -1;
        }
        moveToHead(obj);
        return obj.val;
    }

    /**
     * 如果key不存在，插入头部；如果导致超出容量，删除最久的节点；
     * 如果key存在，变更value，并且将节点移动到头部
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkNode obj = cache.get(key);
        if (obj == null) {
            obj = new DLinkNode(key,value);
            cache.put(key, obj);
            addToHead(obj);
            if (cache.size() > capacity) {
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
            }
        } else {
            obj.val = value;
            moveToHead(obj);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode tail = dummyTail.prev;
        removeNode(tail);
        return tail;
    }

    private void moveToHead(DLinkNode node) {
        if (cache.size() == 1) {
            return;
        }
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(DLinkNode node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        node.next.prev = node;
        dummyHead.next = node;
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.put(3,3);
        System.out.println(obj);
    }
}
