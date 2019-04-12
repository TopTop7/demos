package com.poppy.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class UseAtomicInteger {

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.decrementAndGet());

        System.out.println(atomicInteger.compareAndSet(0,5));

        System.out.println(atomicInteger.addAndGet(10));


    }

}
