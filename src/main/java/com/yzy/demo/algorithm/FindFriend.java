package com.yzy.demo.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找朋友
 * @author yangzyh
 * @date 2021/10/5 15:19
 */
public class FindFriend {
    int[] findMyFriend(int length, int[] height) {
        if(length!=height.length) {
            throw new IllegalArgumentException("入参不对");
        }
        int[] friendPositions = new int[length];
        for (int i = 0; i < length-1; i++) {
            for(int j = i + 1; j<length; j++) {
                if(height[i] < height[j]) {
                    friendPositions[i] = j;
                    break;
                } else {
                    friendPositions[i] = 0;
                }
            }
        }
        friendPositions[length-1] = 0;

        return friendPositions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n ; i++) {
            heights[i] = scanner.nextInt();
        }
        int[] result = new FindFriend().findMyFriend(n, heights);
        Arrays.stream(result).forEach(friend-> System.out.print(friend + " "));
    }
}
