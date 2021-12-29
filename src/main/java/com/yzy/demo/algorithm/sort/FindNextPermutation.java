package com.yzy.demo.algorithm.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
 * 时间：O(n)
 * 空间：O(1)
 * 两轮扫描 + 1轮交换
 * 1,从右侧开始寻找一个尽量靠右的较小数，该数右侧必须都为降序， a[i];
 * 2,从右侧开始寻找第一个大于较小数的数 a[j], 作为较大数；
 * 3，交换a[i]和 a[j];
 * 3, 把i后边的数反转。
 * @author yangzyh
 * @date 2021/12/29 23:45
 */
public class FindNextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        FindNextPermutation f = new FindNextPermutation();
        int[] a = {4,5,2,6,3,1};
        f.nextPermutation(a);
        System.out.println(Arrays.toString(a));
        int[] b = {3,2,1};
        f.nextPermutation(b);
        System.out.println(Arrays.toString(b));
        int[] c = {1,2,3};
        f.nextPermutation(c);
        System.out.println(Arrays.toString(c));
    }
}
