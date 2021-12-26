package com.yzy.demo.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 三数之和
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 时间： O(n2)
 * 空间： O(N) 修改了原数组
 * @author yangzyh
 * @date 2021/12/27 0:04
 */
public class ThreeNumSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 1) {
            return result;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            // 用来记录第三个数的指针
            int third = n-1;
            if( first > 0 && nums[first] == nums[first-1]) {
                // 遍历到重复的数了，跳过
                continue;
            }
            int target = -nums[first];
            for (int second = first+1; second < n; second++) {
                if(second > first + 1 && nums[second] == nums[second-1]) {
                    continue;
                }
                while (second < third && nums[third] + nums[second] > target ) {
                    third--;
                }
                if(second == third) {
                    // 没有符合条件的三元组
                    break;
                }
                if(nums[third] + nums[second] == target) {
                    List<Integer> answer = new ArrayList<>();
                    answer.add(nums[first]);
                    answer.add(nums[second]);
                    answer.add(nums[third]);
                    result.add(answer);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {-1,0,1,2,-1,-4};
        System.out.println(new ThreeNumSum().threeSum(array));
    }
}
