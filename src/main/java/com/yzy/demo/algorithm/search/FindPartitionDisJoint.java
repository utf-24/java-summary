package com.yzy.demo.algorithm.search;

import java.io.FilterOutputStream;

/**
 *https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 * @author yangzyh
 * @date 2022/10/24 21:52
 */
public class FindPartitionDisJoint {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }

    public static void main(String[] args) {
        int[] nums = {5,0,3,8,6};
        System.out.println(new FindPartitionDisJoint().partitionDisjoint(nums));
    }

    //作者：LeetCode-Solution
    //链接：https://leetcode.cn/problems/partition-array-into-disjoint-intervals/solution/fen-ge-shu-zu-by-leetcode-solution-t4pm/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
