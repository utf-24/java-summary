package com.yzy.demo.algorithm.structure;

import com.yzy.demo.algorithm.structure.linklist.ListNode;

import java.util.Arrays;

/**
 * @Desc :
 * @Author : yangzyh
 * @Date : 2025/3/24 19:07
 */
public class SpiralMatrix {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] r : res) {
            Arrays.fill(r, -1);
        }
        int x = 0, y = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上 ,"螺旋顺序"
        int i = 0; // 控制方向，取值 0，1，2，3
        while (head != null) {
            res[x][y] = head.val;
            head = head.next;
            // 算下一步要到达的位置，判断需不需要转弯
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n || res[nx][ny] != -1) {
                i = (i + 1) % 4;
                nx = x + dirs[i][0]; ny = y + dirs[i][1];
            }
            x = nx; y = ny;
        }
        return res;
    }
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        ListNode head = createLinkedList(arr);
        int[][] res = new SpiralMatrix().spiralMatrix(3,5, head);
        System.out.println(res);
    }
}
