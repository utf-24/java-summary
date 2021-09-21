package com.yzy.demo.pattern.creational.factory.method.factorymethod.createPeople;

/**
 * @author yangzyh
 * @date 2021/9/21 19:50
 */
public class CreatePeopleClient {
    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();
        System.out.println("first time create white people...");
        Human human = humanFactory.createHuman(WhiteHuman.class);
        human.getColor();
        human.talk();

        System.out.println("second time create black people...");
        human = humanFactory.createHuman(BlackHuman.class);
        human.getColor();
        human.talk();

        System.out.println("third time create yellow people");
        human = humanFactory.createHuman(YellowHuman.class);
        human.getColor();
        human.talk();
    }
}
