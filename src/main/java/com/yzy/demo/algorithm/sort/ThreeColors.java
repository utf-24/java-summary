package com.yzy.demo.algorithm.sort;

/**
 * LC 75
 * @author yangzyh
 * @date 2022/4/21 17:58
 */
public class ThreeColors {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length -1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
    }
}
