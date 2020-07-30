package com.yzy.demo.base.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangzyh
 * @date 2020/7/30 19:57
 */
public class ShuffleTest {
    public static void main(String[] args) {
        var numbers = new ArrayList<Integer>();
        for(int i = 0 ; i<49; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0,6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
