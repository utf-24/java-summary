package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 53 II
 * @author yangzyh
 * @date 2021/8/7 8:40
 */
public class MissingNumber {

    private int getMissingNumber(int[] data) {
        if(data == null || data.length <1) {
            return -1;
        }
        int left = 0;
        int length = data.length;
        int right = data.length -1;
        while (left <= right) {
            int middle = (left + right) /2;
            if(data[middle] !=middle) {
                if(middle == 0 || data[middle-1] == middle-1){
                    return middle;
                }
                right = middle-1;
            } else {
                left = middle+1;
            }

            if (left == length) {
                return length;
            }
        }

        return  -1;
    }

    public static void main(String[] args) {
        int[] a ={0,1,2,3,5};
        System.out.println(new MissingNumber().getMissingNumber(a));
    }
}
