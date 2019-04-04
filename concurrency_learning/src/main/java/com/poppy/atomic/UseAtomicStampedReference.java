package com.poppy.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;

public class UseAtomicStampedReference {
    static AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("小王", 0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread1 = new Thread(() -> {
                for (int j = 0; j < 10; j++)
                    update(String.valueOf(j));
            });
            thread1.start();
            thread1.join();
        }
        System.out.println("value=" + atomicStampedReference.getReference() + " stamp=" + atomicStampedReference.getStamp());

    }

    public static void update(String newValue) {
        String str = atomicStampedReference.getReference();
        Integer stamp = atomicStampedReference.getStamp();
        boolean flag = true;
        if (atomicStampedReference.compareAndSet(str, newValue, stamp, stamp + 1)) {
            System.out.println("修改成功 ");
        } else {
            System.out.println("修改失败，开始循环");
            while (flag) {
                System.out.println("循环中");
                str = atomicStampedReference.getReference();
                stamp = atomicStampedReference.getStamp();
                if (atomicStampedReference.compareAndSet(str, newValue, stamp, stamp + 1)) {
                    System.out.println("修改成功 ");
                    flag = false;
                }
            }
        }
    }
}
