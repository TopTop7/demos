package com.poppy.concurrent_tool.semaphore;


import java.sql.Connection;
import java.util.Random;

/**
 *
 *类说明：测试数据库连接池
 */
public class AppTest {

	private static DBPoolSemaphore dbPool = new DBPoolSemaphore();
	
	//业务线程
	private static class BusiThread extends Thread{
		@Override
		public void run() {
			Random r = new Random();//让每个线程持有连接的时间不一样
			long start = System.currentTimeMillis();
			try {
				Connection connect = dbPool.takeConnect();
				System.out.println("Thread_"+Thread.currentThread().getId()
						+"_获取数据库连接共耗时【"+(System.currentTimeMillis()-start)+"】ms.");
				Thread.sleep(100+r.nextInt(100));
				System.out.println("查询数据完成，归还连接！");
				dbPool.returnConnect(connect);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Thread thread = new BusiThread();
            thread.start();
        }
	}
	
}
