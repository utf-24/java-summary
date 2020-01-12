package com.yzy.demo.controller;

/**
 * @author young
 * @date 2019/5/19 20:34
 */
public class LoginServlet {
    private static String userName;
    private static String passwWord;

    public static void doPost(String name,String passWord){
        try {
            userName = name;
            if(userName.equals("a")){
                Thread.sleep(5000);
            }
            passwWord = passWord;
            System.out.println("userName = "+userName+" passWord = "+passWord + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
