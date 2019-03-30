package com.poppy.thread;

public class JoinThread {
    public static class RunnableDemo implements Runnable {

        private Thread thread;
        public RunnableDemo(Thread thread){
            this.thread=thread;
        }

        public void run() {
            try {
                //线程插队，该线程执行完毕后，RunnableDemo线程才会继续执行
                //join在哪个线程调用，该线程将执行wait()，并释放锁
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("this is runnableDemo");
        }
    }

    public static void main(String[] args) {
        Thread maintThread=Thread.currentThread();
        Thread thread=new Thread(new RunnableDemo(maintThread));
        thread.start();


        try {
            //线程插队，该线程执行完毕后，RunnableDemo线程才会继续执行
            //join在哪个线程调用，该线程将执行wait()，并释放锁
            //执行该插队代码，将永远无法执行"main thread terminate."
            maintThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main thread terminate.");
    }
}
