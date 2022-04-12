package com.yzy.demo.algorithm.offer;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 考察优化时间复杂度的算法
 *
 * @author yangzyh
 * @date 2021/3/20 19:36
 */
public class FindNum {

    /**
     * 剑指offer 39. 数组中某个数的出现次数比其他数字出现的次数之和都多，找到它。
     * 其实就是找中位数
     * 时间复杂度: O(n)
     * @param array
     * @return element count bigger than half of the array's length
     */
    private static int findMoreThanHalfNum(int[] array){
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("传入的数组不符合要求");
        }
        int start = 0, end = array.length-1;
        int mid = array.length>>1;
        int index = portion(array, start, end);
        while (index != mid) {
            if(index > mid) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            if(start == end) break;
            index = portion(array, start, end);
        }
        int result = array[mid];
        if(!checkIsValidArray(array, result)) {
            throw new IllegalArgumentException("数组中没有一个元素的个数超过其他元素个数之和");
        }
        return result;
    }

    /**
     * 不改变数组,更推荐此法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int result = nums[0];
        int times = 1;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i] != result) {
                times--;
                if(times == 0) {
                    result = nums[i];
                    times = 1;
                }
            } else {
                times++;
            }
        }

        return result;
    }

    /**
     * 剑指offer 40. 找到数组中最小的k个数
     * 时间复杂度： O(n)
     * @param array
     * @param  k   最小的k个数
     * @return
     */
    private static int[] getLeastNumbers(int[] array, int k) {
        if(array == null || array.length == 0) {
            throw new IllegalArgumentException("不正确的数组");
        }
        if(array.length == 1) return array;
        int start = 0, end = array.length-1;
        int index = portion(array, start, end);
        while (index != k) {
            if(index < k) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            if(start == end) break;
            index = portion(array, start, end);
        }

        return ArrayUtils.subarray(array, 0, index);
    }

    private static boolean checkIsValidArray(int[] array, int value) {
        int valueCount = 0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i] == value) {
                valueCount++;
            }
        }

        return valueCount > (array.length >>1);
    }

    /**
     * 在数组内的start-end中任选一个值，使得比它小的数字都在左边，比它大的数字都在右边
     * @param array
     * @param start
     * @param end
     * @return 排序后任选值的下标
     */
    private static int portion(int[] array, int start, int end) {
        // 任意选择一个下标
        int index = RandomUtils.nextInt(end - start +1) + start;
        swap(array, index, end);
        int small = start-1;
        for (int i = start; i < end; i++) {
            if(array[i] < array[end]) {
                small++;
                if(small != i) {
                    swap(array, small, i);
                }
            }
        }
        small ++;
        swap(array, small, end);

        return small;
    }

    private static void swap(int[] array, int index, int end) {
        int temp = array[index];
        array[index] = array[end];
        array[end] = temp;
    }

    public static void main(String[] args) {
        //System.out.println("please enter some number to test findMoreThanHalfNum().(enter q to quit)");
        //Scanner scanner = new Scanner(System.in);
        //List<Integer> sourceList = new ArrayList<>();
        //while (scanner.hasNextInt()) {
        //    sourceList.add(scanner.nextInt());
        //}
        //int[] array = sourceList.stream().mapToInt(Integer::intValue).toArray();
        //System.out.println(findMoreThanHalfNum(array) +"'s count is bigger than the rest of the elements in the array");


        System.out.println("please enter some number to test getLeastNumbers().(enter q to quit)");
        Scanner scanner = new Scanner(System.in);
        List<Integer> sourceList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            sourceList.add(scanner.nextInt());
        }
        int[] array = sourceList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(getLeastNumbers(array, 4)) +" are the least numbers in the array");

    }
}
