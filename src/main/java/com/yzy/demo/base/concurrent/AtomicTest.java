package com.yzy.demo.base.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author young
 * @date 2019/9/27 15:43
 */
public class AtomicTest {
    public static void main(String[] args) {
        User oldUser = new User(17,"young");
        User newUser = new User(24,"jack");
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(oldUser);
        atomicReference.compareAndSet(oldUser,newUser);
        System.out.println(atomicReference.get().getAge());
        System.out.println(atomicReference.get().getName());
    }
}
