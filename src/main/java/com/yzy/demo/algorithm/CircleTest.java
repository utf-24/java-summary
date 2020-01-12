package com.yzy.demo.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 假设你站在一个无限大的平面的某一点上，接下来你要按照收到的指令序列依次循环执行。每条指令可能是以下三种之一：
 * S：前进一步，R：向右转90度，L：向左转90度。
 * 现在需要你写一个算法，判断对于给定的指令序列，是否存在“绕圈子”的现象。
 * 所谓“绕圈子”是指：当你无限循环执行给定的指令序列后，存在一个有限的正整数R，使得你所有经过的点都在以初始点为圆心，以R步长度为半径的圆内。另外，我们假设，每一步的长度都是相同的。
 * <p>
 * 输入：
 * 第一行为一个整数n
 * 之后一共有n行，每行为一个指令序列
 * <p>
 * 输入约束：
 * n位于区间[1,50]
 * 从第二行开始，每行字符串长度为1-50，且仅包含字母L, S, R
 * <p>
 * 输出：
 * 仅有一个单词。
 * 按照输入给定的顺序，从第一行开始，每行从第一个字符开始。如果给定的指令序列存在绕圈子的现象，则输出bounded，否则输出unbounded
 * <p>
 * 举例1：
 * 输入
 * 1
 * SRSL
 * 输出
 * unbounded
 * 解释：假设你初始状态向北，你的行动序列依次为前进，右转，前进，左转，此时你仍然向北，但位置已经向东北方挪动了。只要时间足够长，你会一直向东北方前进，所以你没有在绕圈子。
 * <p>
 * 举例2：
 * 输入
 * 2
 * SSSS
 * R
 * 输出
 * bounded
 * 解释：你会一直绕着一个边长为4步的小正方形循环行进，所以你在绕圈子
 *
 * @author young
 * @date 2019/9/30 9:40
 */
public class CircleTest {

    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char MOVE = 'S';
    private static class Player {
        /**
         * 横坐标
         */
        private int xCoordinates;
        /**
         * 纵坐标
         */
        private int yCoordinates;

        /**
         * 方向，默认为上
         */
        private String direction = "up";

        int getxCoordinates() {
            return xCoordinates;
        }

        void setxCoordinates(int xCoordinates) {
            this.xCoordinates = xCoordinates;
        }

        int getyCoordinates() {
            return yCoordinates;
        }

        void setyCoordinates(int yCoordinates) {
            this.yCoordinates = yCoordinates;
        }

        public String getDirection() {
            return direction;
        }

        void setDirection(String direction) {
            this.direction = direction;
        }

        /**
         * 方向数组（顺时针方向）
         */
        private static final String[] DIRECTION_ARRAY = {"up", "right", "down", "left"};

        private void move(char operation) {
            if (isChangeDirection(operation)) {
                doChangeDirection(operation);
            } else if (isMove(operation)) {
                doMove();
            }
        }

        private boolean isChangeDirection(char operation) {
            return operation == RIGHT || operation == LEFT;
        }

        private void doChangeDirection(char operation) {
            int length = DIRECTION_ARRAY.length;
            String direction = this.getDirection();
            // 左移操作
            if (operation == LEFT) {
                if (DIRECTION_ARRAY[0].equals(direction)) {
                    this.setDirection(DIRECTION_ARRAY[3]);
                    return;
                }
                for (int i = length - 1; i > 0; i--) {
                    if (DIRECTION_ARRAY[i].equals(direction)) {
                        this.setDirection(DIRECTION_ARRAY[i - 1]);
                        break;
                    }
                }
            }
            // 右移操作
            if (operation == RIGHT) {
                if (DIRECTION_ARRAY[length - 1].equals(direction)) {
                    this.direction = DIRECTION_ARRAY[0];
                    return;
                }
                for (int i = 0; i < length - 1; i++) {
                    if (DIRECTION_ARRAY[i].equals(direction)) {
                        this.direction = DIRECTION_ARRAY[i + 1];
                        break;
                    }
                }
            }
        }

        private boolean isMove(char operation) {
            return operation == MOVE;
        }

        private void doMove() {
            int x = this.getxCoordinates();
            int y = this.getyCoordinates();
            switch (this.direction) {
                case "up":
                    this.setyCoordinates(++y);
                    break;
                case "right":
                    this.setxCoordinates(++x);
                    break;
                case "down":
                    this.setyCoordinates(--y);
                    break;
                case "left":
                    this.setxCoordinates(--x);
                default:
            }
        }
    }

    /**
     * 操作序列最大重复次数
     */
    private static final int OPERATION_REPEAT = 4;

    /**
     * 检查操作序列是否在绕圈子
     *
     * @param player 玩家对象
     * @param array  操作序列数组
     * @return bounded:在绕圈子，unbounded:没在绕圈子
     */
    private String checkIfBounded(Player player, String[] array) {
        String result = "unbounded";
        // 获取玩家初始的位置
        int xCoordinate = player.getxCoordinates();
        int yCoordinate = player.getyCoordinates();
        // 在最大重试次数范围内重复执行操作序列看是否在绕圈子
        for (int i = 0; i < OPERATION_REPEAT; i++) {
            for (String eachLine : array) {
                char[] eachLineOperations = eachLine.toCharArray();
                for (char operation : eachLineOperations) {
                    player.move(operation);
                }
            }
        }
        if (findRepeatPos(player,xCoordinate,yCoordinate)) {
            // 找到位置重复的点
            result = "bounded";
        }
        return result;
    }

    private boolean findRepeatPos(Player player, int x, int y) {
        return (player.getxCoordinates() == x) && (player.getyCoordinates() == y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 获取操作个数
        int num = Integer.parseInt(br.readLine().trim());
        String[] array = new String[num];
        for (int i = 0; i < num; i++) {
            //把多行操作存入数组
            array[i] = br.readLine();
        }
        CircleTest circleTest = new CircleTest();
        Player player = new Player();
        System.out.println(circleTest.checkIfBounded(player, array));
    }
}
