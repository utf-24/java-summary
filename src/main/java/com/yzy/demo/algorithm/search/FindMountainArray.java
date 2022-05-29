package com.yzy.demo.algorithm.search;

/**
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，
 * 返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangzyh
 * @date 2022/5/29 21:51
 */
public class FindMountainArray {

    /**
     * 时间 O(n)
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length < 3) {
            // 至少三个元素才能形成山脉
            return -1;
        }
        int maxValueIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        if (maxValueIndex == 0 || maxValueIndex == arr.length - 1) {
            return -1;
        }
        for (int j = maxValueIndex - 1; j > 0; j--) {
            if (arr[j] >= arr[j + 1]) {
                return -1;
            }
        }
        for (int k = maxValueIndex + 1; k < arr.length; k++) {
            if (arr[k] >= arr[k - 1]) {
                return -1;
            }
        }

        return maxValueIndex;
    }

    public static void main(String[] args) {
        System.out.println(new FindMountainArray().peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }
}
