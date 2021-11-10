package com.yzy.demo.algorithm.offer;

import com.google.inject.internal.cglib.core.$ObjectSwitchCallback;

import java.util.Arrays;

/**
 * offer 21
 *
 * @author yangzyh
 * @date 2021/11/10 20:22
 */
public class OddEvenInArray {
    /**
     * 时间 O(n)?
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums.length < 2) return nums;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (isEven(nums[start])) {
                if (!isEven(nums[end])) {
                    swap(nums, start, end);
                    end--;
                    start++;
                } else {
                    end--;
                }
            } else {
                start++;
            }
        }

        return nums;
    }

    /**
     *     作者：jyd
     *     链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/mian-shi-ti-21-diao-zheng-shu-zu-shun-xu-shi-qi-4/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int[] exchangeOfficial(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }



    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 4, 9, 11};
        System.out.println(Arrays.toString(new OddEvenInArray().exchange(array)));
    }
}
