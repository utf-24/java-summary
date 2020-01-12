package com.yzy.demo.base.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证泛型对集合的影响
 * @author young
 * @date 2019/10/21 22:18
 */
public class ListNoGeneric {
    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(11));
        a1.add(new String("a1"));

        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new Integer(222));
        a2.add(new String("a2"));

        List<Integer> a3 = a1;
        a3.add(new Integer(333));
        // 不允许向下转型
//        a3.add(new Object());
//        a3.add(new String("a3"));

        List<?> a4 = a1;
        a1.remove(0);
        a4.clear();
//        a4.add(new Object());
    }
}
