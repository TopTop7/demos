package com.poppy.concurrent_tool.semaphore;

import com.poppy.concurrent_tool.pool.SqlConnectImpl;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * 类说明：演示Semaphore用法，一个数据库连接池的实现
 */
public class DBPoolSemaphore {

    private final static int POOL_SIZE = 10;
    //useful表示可用的数据库连接，useless表示已用的数据库连接
    private final Semaphore useful, useless;

    public DBPoolSemaphore() {
        this.useful = new Semaphore(POOL_SIZE);
        this.useless = new Semaphore(0);
    }

    //存放数据库连接的容器
    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    //初始化池
    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.addLast(SqlConnectImpl.fetchConnection());
        }
    }

    /*归还连接*/
    public void returnConnect(Connection connection) throws InterruptedException {
        if (connection != null) {
            System.out.println("当前有" + useful.getQueueLength() + "个线程等待数据库连接！！"
                    + "可用连接数:" + useful.availablePermits());
            useless.acquire();
            synchronized (pool) {
                pool.addLast(connection);
            }
            useful.release();
        }
    }

    /*从池子拿连接*/
    public Connection takeConnect() throws InterruptedException {
        System.out.println(Thread.currentThread().getId() + "准备获取信号量");
        //获取信号量成功，将继续执行，否则阻塞等待信号量释放
        useful.acquire();
        System.out.println(Thread.currentThread().getId() + "获取信号量成功");
        Connection conn;
        synchronized (pool) {
            conn = pool.removeFirst();
        }
        useless.release();
        return conn;
    }

}
