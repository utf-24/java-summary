package com.yzy.demo.algorithm.sort;

/**
 * LC 977
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangzyh
 * @date 2022/4/22 15:45
 */
public class SortSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0, j = n-1, pos = n-1 ; i<=j;) {
            if (nums[i] * nums[i] <= nums[j]*nums[j]) {
                result[pos] = nums[j] * nums[j];
                j--;
            } else {
                result[pos] = nums[i] * nums[i];
                i++;
            }
            pos--;
        }

        return  result;
    }
}
