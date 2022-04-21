package com.yzy.demo.algorithm.sort;

/**
 * LC 88
 * @author yangzyh
 * @date 2022/4/21 14:45
 */
public class MergeTwoArray {
    //输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //输出：[1,2,2,3,5,6]
    //
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
            for (int j = m+i; j > 0 ; j--) {
                if (nums1[j] < nums1[j-1]){
                    int temp = nums1[j];
                    nums1[j] = nums1[j - 1];
                    nums1[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        new MergeTwoArray().merge(a, 3, new int[]{2,5,6}, 3);
        System.out.println(a);
    }
}
