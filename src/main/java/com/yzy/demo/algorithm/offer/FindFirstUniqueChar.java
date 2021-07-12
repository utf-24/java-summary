package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 50
 *
 * @author yangzyh
 * @date 2021/7/12 22:41
 */
public class FindFirstUniqueChar {

    public char firstUniqChar(String s) {
        int[] charBucket = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charBucket[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(charBucket[s.charAt(i)] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new FindFirstUniqueChar().firstUniqChar("abc"));
    }
}
