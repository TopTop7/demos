package com.poppy.concurrent_tool;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 *循环屏障
 *类说明：CyclicBarrier的使用
 */
public class UseCyclicBarrier {
	
	private static CyclicBarrier barrier 
		= new CyclicBarrier(4,new CollectThread());
	
    private static ConcurrentHashMap<String,Long> resultMap
            = new ConcurrentHashMap<>();//存放子线程工作结果的容器

    public static void main(String[] args) {
        for(int i=0;i<=4;i++){
            Thread thread = new Thread(new SubThread());
            thread.start();
        }

    }

    //负责屏障开放以后的工作
    private static class CollectThread implements Runnable{

        @Override
        public void run() {
            StringBuilder result = new StringBuilder();
            for(Map.Entry<String,Long> workResult:resultMap.entrySet()){
            	result.append("["+workResult.getValue()+"]");
            }
            System.out.println("全部到达await之后，打印结果 = "+ result);
        }
    }

    //工作线程
    private static class SubThread implements Runnable{

        @Override
        public void run() {
        	long id = Thread.currentThread().getId();//线程本身的处理结果
            resultMap.put(Thread.currentThread().getId()+"",id);
            Random r = new Random();//随机决定工作线程的是否睡眠
            try {
                /*if(r.nextBoolean()) {
                	Thread.sleep(2000+id);
                	System.out.println("Thread_"+id+" 开始工作 ");
                }*/
                System.out.println("Thread_"+id+" 开始工作 ");

                System.out.println(id+"到达await，等待其他线程到达");
                barrier.await();
                //需要等待CyclicBarrier(int parties, Runnable barrierAction)中barrierAction执行完成后，才会继续执行

                Thread.sleep(1000+id);
                System.out.println("Thread_"+id+" 继续执行 ");
            } catch (Exception e) {
                e.printStackTrace();
            }
 /*  打印结果显示
                Thread_11 开始工作
                11到达await，等待其他线程到达
                Thread_14 开始工作
                Thread_15 开始工作
                Thread_13 开始工作
                Thread_12 开始工作
                13到达await，等待其他线程到达
                15到达await，等待其他线程到达
                14到达await，等待其他线程到达
                12到达await，等待其他线程到达
                全部到达await之后，打印结果 = [11][12][13][14][15]
                Thread_11 继续执行
                Thread_12 继续执行
                Thread_13 继续执行
                Thread_14 继续执行
                Thread_15 继续执行*/
        }
    }
}
