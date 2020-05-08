package com.yzy.demo.base.innerClass;

/**
 * 静态内部类
 *
 * @author yangzyh
 * @date 2020/4/29 20:52
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        var values = new double[20];
        for(int i = 0; i< values.length; i++) {
            values[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(values);
        System.out.println("min= "  + p.getFirst());
        System.out.println("max= " + p.getSecond());
    }
    static class ArrayAlg {

        public static class Pair {
            private double first;
            private double second;

            public Pair(double f , double s) {
                first = f;
                second = s;
            }

            public double getFirst() {
                return first;
            }

            public double getSecond() {
                return second;
            }
        }

        public static Pair minmax(double[] values) {
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;

            for(double v: values) {
                if(min> v) min = v;
                if(max < v) max = v;
            }

            return  new Pair(min, max);
        }
    }
}
