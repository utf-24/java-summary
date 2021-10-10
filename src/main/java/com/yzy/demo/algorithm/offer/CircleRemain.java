package com.yzy.demo.algorithm.offer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指offer 62
 * @author yangzyh
 * @date 2021/10/10 22:22
 */
public class CircleRemain {
    public int LastRemaining(int n, int m){
        List<Integer> circle = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            circle.add(i);
        }
        int current = 0;
        while( circle.size() > 1) {
            for (int i = 0; i < m-1; i++) {
                current++;
                if(current == circle.size()) {
                    current = 0;
                }
            }
            int next = current;
            int deletedNum = circle.remove(current);
            System.out.println(deletedNum + " remove...");
            if(next == circle.size()) {
                next = 0;
            }
            current = next;
        }

        return circle.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new CircleRemain().LastRemaining(4,3));
    }
}
