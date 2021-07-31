package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 51
 *
 * @author yangzyh
 * @date 2021/7/31 16:32
 */
public class FindInversePair {

    public int inversePair(int[] data) {
        int length = data.length;
        if (length < 1) {
            return 0;
        }
        int[] copy = new int[length];
        System.arraycopy(data, 0, copy, 0, length);

        return inversePairCore(data, copy, 0, length - 1);
    }

    private int inversePairCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inversePairCore(copy, data, start, start + length);
        int right = inversePairCore(copy, data, start + length + 1, end);

        // i初始化为前半段最后一个位置
        int i = start + length;
        // j初始化为后半段最后一个位置
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length
                + 1) {
            if (data[i] > data[j]) {
                count += j - start - length
                ;
                copy[indexCopy--] = data[i--];
            } else {
                copy[indexCopy--] = data[j--];
            }
        }
        for (; i >= start; i--) {
            copy[indexCopy--] = data[i];
        }
        for (; j >= start + length
                + 1; j--) {
            copy[indexCopy--] = data[j];
        }

        return left + right + count;
    }

    public static void main(String[] args) {
        int data[] = {7, 5 ,6, 4};
        System.out.println(new FindInversePair().inversePair(data));
    }
}
