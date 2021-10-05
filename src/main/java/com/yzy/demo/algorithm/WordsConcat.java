package com.yzy.demo.algorithm;

import java.util.*;

/**
 * 单词接龙
 * @author yangzyh
 * @date 2021/10/5 13:59
 */
public class WordsConcat {

    public String findLongestWords(int index, int num, List<String> inputWords) {
        if(index < 0 || index > num-1) {
            throw new IllegalArgumentException("入参不对");
        }
        // 保存结果
        StringBuilder result = new StringBuilder();
        String firstWord = inputWords.get(index);
        result.append(firstWord);
        inputWords.remove(index);
        inputWords.sort((o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            if(len1 !=len2) {
                return len2-len1;
            } else {
                return o1.compareTo(o2);
            }
        });

        int resultLength = -1;
        while (resultLength != result.length()) {
            resultLength = result.length();
            String lastChar = result.substring(result.length()-1);
             for (String word: inputWords) {
                if(word.startsWith(lastChar)) {
                    result.append(word);
                    inputWords.remove(word);
                    break;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        List<String> inputWords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputWords.add(in.nextLine());
        }
        System.out.println(new WordsConcat().findLongestWords(k, n, inputWords));
    }
}
