package com.yzy.demo.algorithm.dp;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @author yangzyh
 * grid[i][j] 存放每个格子的步数
 * dp[i][j] 存放到每个位置的最小路径和
 * i=0;         dp[0][j] = dp[0][j-1] + grid[0][j]
 * j=0;         dp[i][0] = dp[i-1][0] + grid[i][0]
 * i>0 && j>0;  dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
 * @date 2022/1/8 16:39
 */
public class FindMinPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][]dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        // 先确定第一行、第一列各位置的最短路径
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows-1][columns-1];
    }
}
