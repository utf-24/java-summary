package com.yzy.demo.algorithm.greed;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * [2,3,1,1,4]
 * @author yangzyh
 * @date 2022/3/1 18:41
 */
public class JumpToEnd {

    public boolean canJump(int[] nums) {
        int rightMost = 0;
        int length = nums.length;
        for (int i = 0; i < length ; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if ( rightMost >= length-1) {
                    return true;
                }
            }
        }
        return false;
    }
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        System.out.println(new JumpToEnd().canJump(new int[] {2,3,1,1,4}));
        System.out.println(new JumpToEnd().canJump(new int[] {3,2,1,0,4}));
    }
}
