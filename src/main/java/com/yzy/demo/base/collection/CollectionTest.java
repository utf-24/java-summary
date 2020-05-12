package com.yzy.demo.base.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author young
 * @date 2019/10/15 9:36
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i< 10; i++){
            list.add(String.valueOf(i));
        }
        list.add("expand");
        System.out.println(list);
    }
}
