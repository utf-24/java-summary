package com.yzy.demo.base.generic;

import java.time.LocalDate;

/**
 * 获取数组的最大最小值
 *
 * @author yangzyh
 * @date 2020/7/4 10:29
 */
public class PairTest<E> {
    static class ArrayAlg {
        static<T extends Comparable> Pair<T> minmax(T[] a) {
            if((null == a || (a.length == 0))) {
                return null;
            }
            T min = a[0];
            T max = a[0];

            for (T element : a) {
                if (element.compareTo(min) >= 0) {
                    max = element;
                } else {
                    min = element;
                }
            }

            return new Pair<>(min, max);
        }
    }

    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1907,12,9),
                LocalDate.of(1997,12,9),
                LocalDate.of(1995,8,4),
                LocalDate.of(2001,3,3),
        };

        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min= " + mm.getFirst());
        System.out.println("max= " + mm.getSecond());
    }
}
