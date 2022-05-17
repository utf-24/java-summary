package com.yzy.demo.algorithm.search;

/**
 * LC 162
 * @author yangzyh
 * @date 2022/5/17 22:54
 */
public class PeakElement {
    public int findPeakElement(int[] nums) {
        int idx = 0 ;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(new PeakElement().findPeakElement(new int[] {1,2,3,4}));
    }
}
