package com.yzy.demo.algorithm.search;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.cn/problems/get-kth-magic-number-lcci/
 * 找出第k个只包含3，5，9素因子的数
 * 输入: k = 5
 * 输出: 9
 * @author yangzyh
 * @date 2022/9/28 19:57
 */
public class FindKthMagicNumber {
    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int magic = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            magic = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return magic;
    }

    //作者：LeetCode-Solution
    //链接：https://leetcode.cn/problems/get-kth-magic-number-lcci/solution/di-k-ge-shu-by-leetcode-solution-vzp7/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        System.out.println(new FindKthMagicNumber().getKthMagicNumber(5));
    }
}
