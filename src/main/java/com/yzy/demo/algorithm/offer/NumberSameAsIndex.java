package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 53 III
 * @author yangzyh
 * @date 2021/8/7 9:05
 */
public class NumberSameAsIndex {
    int getNumberSameAsIndex(int[] data) {
        int left = 0;
        int length = data.length;
        int right = length-1;
        while(left <= right) {
            int middle = (left +right)/2;
            if(data[middle] == middle) {
                return middle;
            }

            if(data[middle] > middle){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a ={-3,-1,1,3,5};
        System.out.println(new NumberSameAsIndex().getNumberSameAsIndex(a));
    }
}
