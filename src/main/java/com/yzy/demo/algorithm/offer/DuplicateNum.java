package com.yzy.demo.algorithm.offer;

import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.google.inject.internal.cglib.proxy.$Enhancer;

/**
 * 剑指offer 3
 * @author yangzyh
 * @date 2021/11/1 18:54
 */
public class DuplicateNum {

    /**
     * 时间 O(n)
     * 空间 O(n)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if(nums.length< 2) {
            return -1;
        }

        int repeatNum = -1;
        int[] numCountBucket = new int[nums.length];

        for (int num: nums) {
            numCountBucket[num]++;
        }

        for (int i = 0; i< nums.length; i++) {
            if(numCountBucket[i] > 1) {
                return i;
            }
        }

        return repeatNum;
    }

    public int findRepeatNumberOfficial(int[] nums){
        if(nums.length < 2){
            return -1;
        }
        int repeatNum = -1;
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                // 如果当前下标的数字和 这个数字所在下标的值相等，说明找到重复的数字了
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 交换当前下标的数字到这个数字对应的下标，如0该在num是[0]
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return repeatNum;
    }

    /**
     * 题目2
     * @param nums
     * @return
     */
    public int findRepeatNumberImmutable(int[] nums) {
        if( nums.length  < 2) {
            return -1;
        }
        int start =1;
        int end = nums.length-1;
        while (end >=start) {
            // 重点，+start
            int middle = ((end -start) >> 1) +start;
            int count = countRange(nums, start, middle);
            if(end == start) {
                if(count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            // start 到middle的数量超了，因此这个范围内肯定有重复的数
            if(count > (middle - start +1)) {
                end = middle;
            } else {
                start = middle +1;
            }
        }

        return -1;
    }

    private int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= end) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] a = {2,3,5,4,3,2,6,7};
        //System.out.println(new DuplicateNum().findRepeatNumber(a));
        //System.out.println(new DuplicateNum().findRepeatNumberOfficial(a));
        System.out.println(new DuplicateNum().findRepeatNumberImmutable(a));
    }
}
