package com.yzy.demo.algorithm.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangzyh
 * @date 2021/9/17 21:09
 */
public class SlidingWindow {

    /**
     * 剑指offer 59 I
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length <1) return new int[0];
        //窗口数
        int[] res = new int[nums.length - k +1];
        LinkedList<Integer> queue = new LinkedList<>();
        // 遍历数组中元素，right表示滑动窗口右边界
        for(int right =0; right < nums.length; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            // 源数组下标入队列
            queue.addLast(right);
            // 计算窗口左侧边界
            int left = right - k + 1;
            // 当队首元素的下标小于滑动窗口左侧边界left时
            // 表示队首元素已经不再滑动窗口内，因此将其从队首移除
            if(queue.peekFirst() < left){
                queue.removeFirst();
            }
            if(right +1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        System.out.println(Arrays.toString(new SlidingWindow().maxSlidingWindow(nums, 2)));
    }
}
