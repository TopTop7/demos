package com.poppy.atomic;



import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class UseAtomicReference {
    public static   AtomicReference<People> atomicReference =new AtomicReference();
    public static void main(String[] args) {
        People people=new People("小王");
        atomicReference.set(people);
        System.out.println(atomicReference.get().getName());
        People UpdatePeople=new People("小高");
        //保证原子性的修改对象的引用
        atomicReference.compareAndSet(people,UpdatePeople);
        System.out.println(atomicReference.get().getName());

        /**
         * 解决ABA的问题的两个类
         */
        //AtomicMarkableReference
        //AtomicStampedReference
    }
}
@Data
@AllArgsConstructor
class People{
    private String Name;
}
