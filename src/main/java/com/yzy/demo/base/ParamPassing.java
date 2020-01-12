package com.yzy.demo.base;
public class ParamPassing {
    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuilder stringBuilder = new StringBuilder("old stringBuilder");

    public static void main(String[] args) {
        method(intStatic);
        method(stringStatic);
        method(stringBuilder,stringBuilder);
        System.out.println(intStatic);
        method();
        System.out.println(intStatic);
        System.out.println(stringStatic);
        System.out.println(stringBuilder);
    }

    private static void method(int intStatic) {
        intStatic = 777;
    }

    private static void method() {
        intStatic = 888;
    }

    private static void method(String stringStatic) {
        stringStatic = "new String";
    }

    private static void method(StringBuilder stringBuilder1, StringBuilder stringBuilder2) {
        stringBuilder1.append(".method.first-");
        stringBuilder2.append("method.second-");

        stringBuilder1 = new StringBuilder("new stringBuilder");
        stringBuilder1.append("new method's append");
    }
}
