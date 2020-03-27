package com.yzy.demo.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * list集合根据元素某个属性排序
 *
 * @author yangzyh
 * @date 2020/3/27 15:53
 */
public class ListSortTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setAge(19);
        user1.setScore(29);
        user1.setTime("2020-03-26 10:13:07.965000");
        list.add(user1);
        User user2 = new User();
        user2.setAge(65);
        user2.setTime("2020-03-26 10:13:07.914000");
        user2.setScore(322);
        list.add(user2);
        User user3 = new User();
        user3.setTime("2020-03-26 10:13:08.068000");
        user3.setAge(19);
        user3.setScore(89);
        list.add(user3);
        for(User u:list){
            System.out.println(u.getTime());
        }
        System.out.println("-----------");
        List<User> listSort = list.stream().sorted(Comparator.comparing(User::getTime)).collect(Collectors.toList());
        for(User u:listSort){
            System.out.println(u.getTime());
        }
    }
}
