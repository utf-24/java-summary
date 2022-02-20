package com.yzy.demo.algorithm;

/**
 * 盛水最大的面积
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author yangzyh
 * @date 2022/2/20 17:13
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
