package com.yzy.demo.algorithm.offer;

/**
 * offer 11
 * @author yangzyh
 * @date 2021/11/5 20:21
 */
public class MinNumInArray {
    public int minArray(int[] numbers) {
        if(numbers.length ==1) {
         return numbers[0];
        }
        int start = 0;
        int end = numbers.length-1;
        int mid = start;
        while (numbers[start] >= numbers[end]) {
            if(end - start == 1) {
                return numbers[end];
            }
            mid = (end + start) >>1;
            if(numbers[start] == numbers[end] && numbers[start] == numbers[mid]) {
                return minArrayForeach(numbers);
            }
            if(numbers[mid] >= numbers[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return numbers[mid];
    }

    private int minArrayForeach(int[] numbers) {
        int minNum = numbers[0];
        for (int num: numbers) {
            if(minNum > num){
                minNum = num;
            }
        }

        return minNum;
    }

    public static void main(String[] args) {
        int[] a = {3,4,5,1,2};
        int[] b = {2,2,2,0,1};
        System.out.println(new MinNumInArray().minArray(a));
        System.out.println(new MinNumInArray().minArray(b));
    }
}
