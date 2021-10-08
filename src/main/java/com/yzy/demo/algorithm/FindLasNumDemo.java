package com.yzy.demo.algorithm;

/**
 * @author yangzyh
 * @date 2021/10/8 19:26
 */
public class FindLasNumDemo {
    public int maximumSwap(int num) {
        String numOfStr = String.valueOf(num);
        char[] numOfChar = numOfStr.toCharArray();
        int length = numOfChar.length;
        //每个数字最后出现的位置
        int[] last = new int[10];
        for (int i = 0; i < length; i++) {
            last[numOfChar[i] - '0'] = i;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 9; j > 0; j--) {
                if (last[j] > i && j > numOfChar[i] - '0') {
                    swap(numOfChar, i, last[j]);
                    return Integer.parseInt(new String(numOfChar));
                }
            }
        }
        return num;
    }

    private void swap(char[] numOfChar, int a, int b) {
        char temp = numOfChar[a];
        numOfChar[a] = numOfChar[b];
        numOfChar[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new FindLasNumDemo().maximumSwap(10202));
        System.out.println(new FindLasNumDemo().maximumSwap(9973));
        System.out.println(new FindLasNumDemo().maximumSwap(2736));
        System.out.println(new FindLasNumDemo().maximumSwap(101));
    }
}
