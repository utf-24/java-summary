package com.yzy.demo.algorithm.structure.linklist;

import java.util.ArrayDeque;

/**
 * @author yangzyh
 * @date 2024/4/28 20:37
 */
public class FindTotalSteps {
    public int totalSteps(int[] nums) {
        int answer = 0;
        ArrayDeque<int[]> temp = new ArrayDeque<>();
        for (int num: nums) {
            int maxT = 0;
            while (!temp.isEmpty() && temp.peek()[0] <= num) {
                maxT = Math.max(maxT, temp.pop()[1]);
            }
            maxT = temp.isEmpty()? 0: maxT + 1;
            answer = Math.max(answer, maxT);
            temp.push(new int[]{num, maxT});
        }
        return answer;
    }

    public static void main(String[] args) {
        //int[] nums = {5,3,4,4,7,3,6,11,8,5,11};
        int[] nums = {20,1,9,1,2,3};
        System.out.println(new FindTotalSteps().totalSteps(nums));
    }
    //作者：灵茶山艾府
    //链接：https://leetcode.cn/problems/steps-to-make-array-non-decreasing/solutions/1524614/by-endlesscheng-s2yc/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
