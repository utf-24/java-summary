package com.yzy.demo.base.concurrent.thread.threadlocal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 参考《码出高效》p.254
 *
 * @author young
 * @date 2020/1/26 13:53
 */
public class CsGameByThreadLocal {
    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_ENEMIES = 0;
    private static final Integer LIFE_VALUE = 10;
    private static final Integer TOTAL_PLAYERS = 10;
    /**
     * 随机数用来展示每个对象的不同数据
     */
    private static final ThreadLocalRandom RANDOM
            = ThreadLocalRandom.current();

    /**
     * 初始化子弹数
     */
    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL
            = ThreadLocal.withInitial(() -> BULLET_NUMBER);

    /**
     * 初始化杀敌数
     */
    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL
            = ThreadLocal.withInitial(() -> KILLED_ENEMIES);

    /**
     * 初始化生命数
     */
    private static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL
            = ThreadLocal.withInitial(() -> LIFE_VALUE);

    private static class Player extends Thread {

        @Override
        public void run() {
            Integer bullets = BULLET_NUMBER_THREADLOCAL.get() -
                    RANDOM.nextInt(BULLET_NUMBER);
            Integer killEnemies = KILLED_ENEMIES_THREADLOCAL.get() +
                    RANDOM.nextInt(TOTAL_PLAYERS / 2);
            Integer lifeValue = LIFE_VALUE_THREADLOCAL.get() -
                    RANDOM.nextInt(LIFE_VALUE);
            System.out.println(getName() + ", bullet_number: " + bullets);
            System.out.println(getName() + ", killed_enemies: " + killEnemies);
            System.out.println(getName() + ", life_value is: " + lifeValue);

            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_ENEMIES_THREADLOCAL.remove();
            LIFE_VALUE_THREADLOCAL.remove();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_PLAYERS; i++) {
            new Player().start();
        }
    }
}
