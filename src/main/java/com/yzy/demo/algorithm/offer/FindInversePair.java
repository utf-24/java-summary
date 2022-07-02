package com.yzy.demo.algorithm.offer;

import java.util.Arrays;

/**
 * 剑指offer 51
 *
 * @author yangzyh
 * @date 2021/7/31 16:32
 */
public class FindInversePair {

    public int inversePairs(int[] data) {
        int length = data.length;
        if (length < 1) {
            return 0;
        }
        int[] copy = new int[length];
        System.arraycopy(data, 0, copy, 0, length);

        return inversePairCore(data, copy, 0, length - 1);
    }

    private int inversePairCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            //copy[start] = data[start];  //why
            return 0;
        }
        int halfLength = (end - start) / 2;
        int left = inversePairCore(copy, data, start, start + halfLength);
        int right = inversePairCore(copy, data, start + halfLength + 1, end);

        // i初始化为前半段最后一个位置
        int firstHalfEndIdx = start + halfLength;
        int i = firstHalfEndIdx;
        // j初始化为后半段最后一个位置
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + halfLength + 1) {
            if (data[i] > data[j]) {
                count += j - firstHalfEndIdx;
                copy[indexCopy--] = data[i--];
            } else {
                copy[indexCopy--] = data[j--];
            }
        }
        for (; i >= start; i--) {
            copy[indexCopy--] = data[i];
        }
        for (; j >= start + halfLength + 1; j--) {
            copy[indexCopy--] = data[j];
        }

        return left + right + count;
    }

    int findInversePir(int[] nums) {
        if (nums.length == 0) return 0;
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        return doFindInversePair(nums, copy, 0, nums.length - 1);
    }

    public int doFindInversePair(int[] data, int[] copy, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = doFindInversePair(copy, data, left, mid);
        int rightCount = doFindInversePair(copy,data, mid + 1, right);
        int copyIndex = right;
        int count = 0;
        int i = mid, j = right;
        while (i >= left && j >= mid + 1) {
            if (data[i] > data[j]) {
                // 之前的都是逆序对
                count += (j - mid);
                copy[copyIndex--] = data[i--];
            } else {
                copy[copyIndex--] = data[j--];
            }
        }
        while (i >= left) {
            copy[copyIndex--] = data[i--];
        }
        while (j >= mid + 1) {
            copy[copyIndex--] = data[j--];
        }
        return count + leftCount + rightCount;
    }

    public static void main(String[] args) {
        int data[] = {7, 5, 6, 4};
        //int data[] = {};
        //System.out.println(new FindInversePair().inversePairs(data));
        System.out.println(new FindInversePair().findInversePir(data));
        System.out.println(Arrays.toString(data));
    }
}
