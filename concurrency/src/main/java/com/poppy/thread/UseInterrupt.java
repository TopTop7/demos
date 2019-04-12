package com.poppy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的三种方式
 */
public class UseInterrupt {

    static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    /**
     * 第一种方式
     */
    public static class ThreadDemo extends Thread {
        @Override
        public void run() {
            while (isInterrupted()) {
                System.out.println("this is thread demo");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("theadId=" + Thread.currentThread().getName() + " theadName=" + Thread.currentThread().isInterrupted());
            }
        }
    }

    /**
     * 第二种方式
     */
    public static class RunableDemo implements Runnable {

        public void run() {

            System.out.println("this is runnableDemo");
        }
    }

    /**
     * 第三种方式
     */
    public static class CallableDemo implements Callable {

        public String call() {
            threadLocal.set("callable");
            System.out.println("this is CallableDemo");
            System.out.println(threadLocal.get());
            return "call";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        threadDemo.interrupt();




        FutureTask task = new FutureTask(new CallableDemo());

        new Thread(task).start();
        System.out.println(task.get());
    }
}
