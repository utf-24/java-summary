package com.yzy.demo.base;

import lombok.Data;

/**
 * @author young
 * @date 2019/10/19 10:32
 */
@Data
public class People {
    private int age;
    private String name;

    public static void main(String[] args) {
        People people = new People();
        people.setAge(10);
        people.setName("a");
        System.out.println("before: "+people);
        changePeople(people);
        System.out.println("after: " + people);
    }

    static void changePeople(People people){
        people.setName("b");
        people.setAge(11);

    }
}
