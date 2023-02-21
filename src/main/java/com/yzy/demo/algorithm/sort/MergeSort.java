package com.yzy.demo.algorithm.sort;

/**
 * @author yangzyh
 * @date 2021/7/31 15:54
 */
public class MergeSort {
    /**
     * top-down
     *
     * @param nums
     * @param l
     * @param h
     * @return
     */
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h)
            return new int[]{nums[l]};

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }

    /**
     * Bottom-up
     * 时间nlogn
     * 空间 n还是1? orderedArr算n吧
     * @param arr
     */
    public static void merge_sort(int[] arr) {
        //辅助数组，暂存每次子数组的排序结果，排序后复制到原数组
        int[] orderedArr = new int[arr.length];
        //子数组从2，4一直到n，每次使得子数组有序 arr.length * 2 防止只有两个元素时2<2不成立， 是不是arr.length + 1就行？
        for (int i = 2; i < arr.length * 2; i *= 2) {
            // 确定有几个子数组，如果直接 length/i，可能会少一组，如 9/2 = 4， 实际是五组；加i再减1保证不会多一组
            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                //每个子数组的最左元素
                int left = i * j;
                //每个子数组的中间元素
                int mid = left + i / 2 >= arr.length ? (arr.length - 1) : (left + i / 2);
                //每个子数组的最右元素
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 10};
        //int[] newNums = mergeSort(nums, 0, nums.length - 1);
        merge_sort(nums);
        for (int x : nums) {
            System.out.println(x);
        }
    }
}
