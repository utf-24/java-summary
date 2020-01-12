package com.yzy.demo.concurrent.thread.db;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author young
 * @date 2019/9/24 10:52
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if(initialSize > 0) {
            for(int i = 0 ;i< initialSize; i++) {
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 添加后需要进行通知，这样其他消费者能够感知到链接池中已经归还了一个链接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 获取连接
     * @param mills  超时后返回null
     * @return
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            // 忽略超时
            if(mills <= 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remain = mills;
                // 在超时范围内不断尝试获取数据库连接
                while(pool.isEmpty() && remain > 0) {
                    pool.wait();
                    remain = future - System.currentTimeMillis();
                }
                Connection connection = null;
                if(!pool.isEmpty()){
                    connection = pool.removeFirst();
                }
                return connection;
            }
        }
    }

}
