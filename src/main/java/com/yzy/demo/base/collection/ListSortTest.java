package com.yzy.demo.base.collection;

import java.util.*;
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
        User user4 = new User();
        user4.setTime("2020-03-26 10:13:07.914000");
        user4.setAge(11);
        user4.setScore(33);
        list.add(user4);

        User user5 = new User();
        user5.setTime("2020-03-26 10:13:07.914001");
        user5.setAge(11);
        user5.setScore(33);
        list.add(user5);

        User user6 = new User();
        user6.setTime("2020-03-26 10:13:07.914000");
        user6.setAge(11);
        user6.setScore(33);
        list.add(user6);

        User user7 = new User();
        user7.setTime("2020-03-26 10:13:07.914001");
        user7.setAge(11);
        user7.setScore(33);
        list.add(user7);

        for(User u:list){
            System.out.println(u.getTime());
        }
        System.out.println("-----------");
        //根据时间排序 如果比较对象为空会抛出NPE，需要重写Comparator接口吧
        List<User> listSort = list.stream().sorted(Comparator.comparing(User::getTime))
                .collect(Collectors.toList());
        for(User u:listSort){
            System.out.println(u.getTime());
        }

        // 根据时间排序，并删除时间相同的重复数据
        ArrayList<User> resultList = list.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(User::getTime))), ArrayList::new));

        System.out.println(resultList);
    }
}
