package com.poppy.concurrent_tool.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Employee implements Runnable {
    private String id;
    private Semaphore semaphore;
    private static Random rand= new Random(47);

    public Employee(String id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            //获取许可
            semaphore.acquire();
            System.out.println(this.id + "正在使用厕所");
            //使用睡眠工具类
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
            //释放许可
            semaphore.release();
            System.out.println(this.id + "上完厕所，离开");
        } catch (InterruptedException e) {
        }
    }
}

class ToiletRace {
    //30个人
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(THREAD_COUNT);

    //10个坑 = 10个许可,用完就得排队等待
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Employee(String.valueOf(i), s));
        }

        threadPool.shutdown();
    }
}

