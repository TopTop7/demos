package com.poppy.concurrent_tool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

/**
 *用于两个线程之间数据的交换,【必须是有且只有两个线程】
 *
 *类说明：Exchange的使用
 */
public class UseExchange {
    //定义交换器
    private static final Exchanger<Set<String>> exchange 
    	= new Exchanger<Set<String>>();

    public static void main(String[] args) {

    	//第一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
            	Set<String> setA = new HashSet<String>();//存放数据的容器
                try {
                	//添加数据
                	 setA.add("setA");

                	setA = exchange.exchange(setA);//交换set
                	/*处理交换后的数据*/
                    System.out.println("ThreadA的Set值="+setA);
                } catch (InterruptedException e) {
                }
            }
        }).start();

      //第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
            	Set<String> setB = new HashSet<String>();//存放数据的容器
                try {
                    //添加数据
                    setB.add("setB");
                	setB = exchange.exchange(setB);//交换set
                	/*处理交换后的数据*/
                    System.out.println("ThreadB的Set值="+setB);
                } catch (InterruptedException e) {
                }
            }
        }).start();

    }
}
