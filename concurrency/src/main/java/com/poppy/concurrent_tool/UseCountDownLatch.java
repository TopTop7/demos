package com.poppy.concurrent_tool;


import java.util.concurrent.CountDownLatch;

/**
 * @author Mark老师   享学课堂 https://enjoy.ke.qq.com
 * <p>
 * 类说明：演示CountDownLatch，有5个初始化的线程，6个扣除点，
 * 扣除完毕以后，主线程和业务线程才能继续自己的工作
 */
public class UseCountDownLatch {

    static CountDownLatch latch = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {
        /**
         *  单独的初始化线程,初始化分为2步，需要扣减两次
         */
        new Thread(() -> {
            System.out.println("Thread_" + Thread.currentThread().getId() + " 初始化1");
            latch.countDown();//每完成一步初始化工作，扣减一次
            System.out.println("Thread_" + Thread.currentThread().getId()
                    + " 初始化2");
            latch.countDown();//每完成一步初始化工作，扣减一次
        }).start();
        new Thread(() -> {
            try {
                System.out.println("await");
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("继续执行");
        }).start();
        /**
         * 开启4个线程
         */
        for (int i = 0; i <= 3; i++) {
            new Thread(() -> {
                System.out.println("Thread_" + Thread.currentThread().getId() + " 开始工作" );
                latch.countDown();//线程完成工作了，countDown方法只扣减一次；
            }).start();
        }
        latch.await();
        System.out.println("Main Thread begining");
    }
}
