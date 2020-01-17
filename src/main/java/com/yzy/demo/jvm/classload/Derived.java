package com.yzy.demo.jvm.classload;

/**
 * 测试类加载顺序，静态变量和静态代码块最先加载，优先级相同，按代码先后顺序；
 * 参考：https://www.zhihu.com/question/49196023
 */
class Log {
    public static String baseFieldInit() {
        System.out.println("Base Normal Field");
        return "";
    }

    public static String baseStaticFieldInit() {
        System.out.println("Base Static Field");
        return "";
    }

    public static String fieldInit() {
        System.out.println("Normal Field");
        return "";
    }

    public static String staticFieldInit() {
        System.out.println("Static Field");
        return "";
    }
}

/**
 * 基类
 */
class Base {
    /*1*/ static {
        System.out.println("Base Static Block 1");
    }

    /*1*/ private static String staticValue = Log.baseStaticFieldInit();

    /*1*/ static {
        System.out.println("Base Static Block 2");
    }

    /*3*/ {
        System.out.println("Base Normal Block 1");
    }

    /*3*/ private String value = Log.baseFieldInit();

    /*4*/ Base() {
        System.out.println("Base Constructor");
    }

    /*3*/ {
        System.out.println("Base Normal Block 2");
    }
}

/**
 * 派生类
 */
public class Derived extends Base {
    /*2*/
    static {
        System.out.println("Static Block 1");
    }
    /*2*/
    private static String staticValue = Log.staticFieldInit();

    /*2*/
    static {
        System.out.println("Static Block 2");
    }
    /*5*/
    {
        System.out.println("Normal Block 1");
    }

    /*5*/
    private String value = Log.fieldInit();

    /*5*/
    {
        System.out.println("Normal Block 2");
    }

    /*6*/
    Derived() {
        System.out.println("Derived Constructor");
    }

    /**
     * MAIN 主线程
     */
    public static void main(String[] args) {
        Derived d = new Derived();
        System.out.println("---第二次实例化不再加载静态变量和静态块---");
        Derived d1 = new Derived();
    }
}