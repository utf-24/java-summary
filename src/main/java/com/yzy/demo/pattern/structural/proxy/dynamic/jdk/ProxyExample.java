package com.yzy.demo.pattern.structural.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理demo
 *
 * @author yangzyh
 * @date 2020/10/9 15:48
 */
public class ProxyExample {
    interface Car{
        void running();
    }

    static class Bus implements Car{
        @Override
        public void running() {
            System.out.println("The bus is running");
        }
    }

    static class Taxi implements Car{
        @Override
        public void running() {
            System.out.println("The taxi is running");
        }
    }

    /**
     * JDK proxy
     */
    static class JDKProxy implements InvocationHandler {

        /**
         * 代理对象
         */
        private Object target;

        public Object getInstance(Object target) {
            this.target = target;
            // 获取代理对象
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before jdk dynamic proxy...");

            return method.invoke(target, args);
        }
    }

    public static void main(String[] args) {
        // 新建jdk代理
        JDKProxy jdkProxy = new JDKProxy();
        Car carInstance = (Car) jdkProxy.getInstance(new Taxi());
        carInstance.running();
    }
}
