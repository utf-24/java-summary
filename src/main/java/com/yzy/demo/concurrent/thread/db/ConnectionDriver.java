package com.yzy.demo.concurrent.thread.db;

import com.yzy.demo.util.SleepUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * 模拟数据库驱动
 * @author young
 * @date 2019/9/24 9:40
 */
public class ConnectionDriver {
    public static final String COMMIT = "commit";
    static class ConnectionHandler implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(COMMIT.equals(method.getName())){
                System.out.println(Thread.currentThread().getName() + " commit");
                SleepUtils.millSeconds(100);
            }
            return null;
        }
    }
    /**
     * 创建一个connection的代理，在提交时休息1秒
     */
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),
                new Class<?>[]{Connection.class}, new ConnectionHandler());
    }
}
