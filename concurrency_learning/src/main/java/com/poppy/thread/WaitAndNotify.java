package com.poppy.thread;

public class WaitAndNotify {

    public static class Account {
        private int money;

        public Account(int money) {
            this.money = money;
        }

        public synchronized void inMoney() {
            if(this.money>200){
                try {
                    System.out.println("等待取钱 money="+money);
                    wait();
                    System.out.println("收到通知，继续执行 money="+money);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else{
                this.money += 50;
                notifyAll();
                System.out.println("通知取钱 money="+money);
            }
        }

        public synchronized void outMoney() {
            if (money < 200) {
                try {
                    System.out.println("没钱了 通知存钱  money="+money);
                    wait();
                    System.out.println("收到通知 可以取钱了  money="+money);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                money -= 200;
                System.out.println("取钱成功   money="+money);
                notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        Account account=new Account(100);
        new Thread(() -> {
            for(int i=0;i<100;i++){
                account.inMoney();
            }
        }).start();
        new Thread(() -> {
            for(int i=0;i<100;i++){
                account.outMoney();
            }
        }).start();
    }
}
