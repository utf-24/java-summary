package com.yzy.demo.pattern.structural.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yangzyh
 * @date 2020/10/9 16:06
 */
public class CGLibExample {

    static class Car {
        public void running() {
            System.out.println("The car is running");
        }
    }

    /**
     * CGLib 代理类
     */
    static class CGLibProxy implements MethodInterceptor {

        /**
         * 目标对象
         */
        private Object target;

        public Object getInstance(Object target) {
            this.target = target;
            Enhancer enhancer = new Enhancer();
            // 设置父类为 target类
            enhancer.setSuperclass(this.target.getClass());
            // 回调方法
            enhancer.setCallback(this);
            // 创建代理对象
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before cglib proxy");
            return methodProxy.invokeSuper(o, objects);
        }
    }

    public static void main(String[] args) {
        // create cglib proxy
        CGLibProxy cgLibProxy = new CGLibProxy();
        Car car = (Car) cgLibProxy.getInstance(new Car());
        car.running();
    }
}
