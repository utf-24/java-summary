package com.yzy.demo.algorithm.search;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 可以在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，
 * 并根据有序的那个部分确定我们该如何改变二分查找的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分
 * 关键点就是数组mid两边肯定有一边是有序数组，就可以判断该有序边是否包含target
 *
 *  [4,5,6,7,0,1,2] target = 0
 * @author yangzyh
 * @date 2022/2/27 23:02
 */
public class FindNumInSpinArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target? 0 : -1;
        }
        int left = 0;
        int right = n-1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n-1]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }

        return -1;
    }

    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {
        System.out.println(new FindNumInSpinArray().search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
