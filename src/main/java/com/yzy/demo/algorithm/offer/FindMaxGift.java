package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 47.
 * f(i,j) = max(f(i-1,j), f(i,j-1)) + gift[i,j]
 *
 * @author yangzyh
 * @date 2021/7/2 23:52
 */
public class FindMaxGift {

    public int maxValue(int[][] grid) {
        // 保存每个位置的最大数
        int[][] maxCount = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int top = 0;
                int left = 0;
                if (i > 0) {
                    top = grid[i - 1][j];
                }
                if (j > 0) {
                    left = grid[i][j - 1];
                }
                //计算到(i,j)坐标的最大值
                maxCount[i][j] = Math.max(top, left) + grid[i][j];
            }
        }

        return maxCount[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        System.out.println(new FindMaxGift().maxValue(grid));
    }
}
