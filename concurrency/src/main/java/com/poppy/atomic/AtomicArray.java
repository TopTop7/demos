package com.poppy.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;


/**
 *
 *原子数组
 */
public class AtomicArray {
    static int[] value = new int[] { 1, 2 };
    
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);
    
    public static void main(String[] args) {
        //AtomicIntegerArray内部维护着一个相同类型的Array数组
        System.out.println(ai.getAndSet(0, 3));
    	System.out.println(ai.get(0));
    	//原有数组的值并未改变
    	System.out.println(value[0]);

    }
}
