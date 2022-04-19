package com.yzy.demo.algorithm.structure.queue;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * LC 238
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangzyh
 * @date 2022/4/19 18:47
 */
public class SlidingWindow {
    //[1,3,-1,-3,5,3,6,7]
    //3
    //[3,3,5,5,6,7]
    //时间n*lgn (优先级队列插入元素是lgn)  空间 n
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 元素不相同时根据元素大小排序，相同时根据下标排序 对头元素是最小的，所以用O2 - O1
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);

        // 第一个k窗口入队
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        int n = nums.length;
        int[] result = new int[n-k+1];
        result[0] = priorityQueue.peek()[0];
        for (int i = k; i < n; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
            while (priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }
            result[i-k+1] = priorityQueue.peek()[0];
        }

        return  result;
    }
    //[1,3,-1,-3,5,3,6,7]
    //3
    //[3,3,5,5,6,7]
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> descQueue = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!descQueue.isEmpty() &&  nums[i] >= nums[descQueue.peekLast()]) {
                descQueue.pollLast();
            }
            descQueue.offerLast(i);
        }
        int[] result = new int[n-k+1];
        result[0] = nums[descQueue.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!descQueue.isEmpty() &&nums[i] >= nums[descQueue.peekLast()]) {
                descQueue.pollLast();
            }
            descQueue.offerLast(i);
            while (descQueue.peekFirst() <= i-k){
                descQueue.pollFirst();
            }
            result[i-k +1] = nums[descQueue.peekFirst()];
        }
        return  result;
    }
}
