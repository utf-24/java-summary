package com.yzy.demo.algorithm.search;

/**
 * LC 74
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * @author yangzyh
 * @date 2022/5/5 21:25
 */
public class FindNumInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            int start = 0;
            int end = columns - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if (i + 1 < rows && matrix[i + 1][0] > target) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new FindNumInMatrix().searchMatrix(matrix, 13));
    }
}
