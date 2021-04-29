package com.yzy.demo.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

import static java.util.Comparator.naturalOrder;


/**
 * 剑指offer41
 * 维护左边的最大堆和右边的最小堆
 */
public class MedianFinder {

    public PriorityQueue minHeap = new PriorityQueue<Integer>(1000, naturalOrder());

    private static Comparator maxFirsComparator = Comparator.naturalOrder().reversed();
    public PriorityQueue maxHeap = new PriorityQueue<Integer>(1000, maxFirsComparator);

    private int count;

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if((count & 1) == 0) {
            //当奇数次添加时，插入最小堆
            if(!maxHeap.isEmpty() && num < (int) maxHeap.peek()) {
                maxHeap.add(num);
                num = (int) maxHeap.poll();
                minHeap.add(num);
            } else {
                minHeap.add(num);
            }
        } else {
            //当偶数次插入时，插入最大堆
            if(!minHeap.isEmpty() && num > (int) minHeap.peek()) {
                minHeap.add(num);
                num = (int) minHeap.poll();
                maxHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        }
        count++;
    }

    public double findMedian() {
        int toTalSize = minHeap.size() + maxHeap.size();
        if((toTalSize & 1) == 0 ) {
            //是偶数
            int min = (int) minHeap.peek();
            int max = (int) maxHeap.peek();
            return (double)(min + max) / 2 ;
        } else {
            int value = (int) minHeap.peek();
            return value;
        }
    }

    //public static void main(String[] args) {
    //     MedianFinder obj = new MedianFinder();
    //     obj.addNum(1);
    //     obj.addNum(2);
    //     obj.addNum(3);
    //    System.out.println(obj.findMedian());
    //}
}

