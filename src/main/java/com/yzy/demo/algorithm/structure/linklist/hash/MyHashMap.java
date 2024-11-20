package com.yzy.demo.algorithm.structure.linklist.hash;

/**
 * https://leetcode.cn/problems/design-hashmap/submissions/547293975/
 * @author yangzyh
 * @date 2024/7/16 20:12
 */
public class MyHashMap {

    private class Pair {
        int key;
        int value;
        Pair next;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Pair[] data;

    public MyHashMap() {
        data = new Pair[1000];
    }

    public void put(int key, int value) {
        int idx = getIdx(key);
        Pair pos = data[idx];
        Pair pair = new Pair(key, value);
        Pair prev = null;
        while (pos != null) {
            if (pos.key == key) {
                pos.value = value;
                return;
            }
            prev = pos;
            pos = pos.next;
        }
        pos = prev;
        if (pos != null) {
            pos.next = pair;
        } else {
            data[idx] = pair;
        }
    }

    public int get(int key) {
        int idx = getIdx(key);
        Pair pair = data[idx];
        while (pair != null) {
            if (pair.key == key){
                return pair.value;
            }
            pair = pair.next;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = getIdx(key);
        Pair pos = data[idx];
        if (pos != null) {
            Pair prev = null;
            while (pos !=null) {
                if (pos.key == key) {
                    if(prev == null) {
                        data[idx] = pos.next;
                    } else {
                        prev.next = pos.next;
                    }
                    return;
                }
                prev = pos;
                pos = pos.next;
            }
        }
    }


    private int getIdx(int key) {
        return Integer.hashCode(key) % data.length;
    }
}


