package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 4， 右上角是突破口
 * @author yangzyh
 * @date 2021/11/1 22:40
 */
public class NumIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length <1) return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0; int column = columns-1;

        while (row < rows && column >=0) {
            if(matrix[row][column] == target) {
                return true;
            } else if(matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array= {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new NumIn2DArray().findNumberIn2DArray(array, 29));
    }
}
