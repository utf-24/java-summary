package com.yzy.demo.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author yangzyh
 * @date 2020/5/26 18:51
 */
public class ProxyTest {
    public static void main(String[] args) {
        var elements = new Object[1000];
        //fill elements with proxies for the Integers
        for (int i = 0; i <elements.length ; i++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                    new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        // construct a random integer
        Integer key =  new Random().nextInt(elements.length);

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        // print match if found
        if(result > 0) {
            System.out.println(elements[result]);
        }
    }

}


/**
 * an invocation handler that prints out the method name
 * invoke the original method
 */
class TraceHandler implements InvocationHandler{
    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // print implicit argument;
        System.out.println(target);
        // print method name
        System.out.println("." + method.getName() +"(");
        // print explicit arguments
        if(args!=null) {
            for (int i = 0; i < args.length ; i++) {
                System.out.println(args[i]);
                if(i<args.length-1){
                    System.out.println(",");
                }
            }
        }
        System.out.println(")");

        //invoke actual method
        return method.invoke(target, args);
    }
}
