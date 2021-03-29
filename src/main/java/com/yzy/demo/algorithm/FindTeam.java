package com.yzy.demo.algorithm;

import java.util.*;

/**
 * @author yangzyh
 * @date 2021/3/28 20:59
 */
public class FindTeam {
    /**
     * @param arrayLength               总人数
     * @param peoplePowerStrings        每个人的能力值
     * @param minPower                  团队需要的最低能力值
     * @return                          最多满足条件的队数
     */
    private static int findMostTeam(int arrayLength, String[] peoplePowerStrings, int minPower) {
        if( arrayLength != peoplePowerStrings.length) {
            throw new IllegalArgumentException("illegal input param!");
        }
        int[] peoplePowerInt = convertString2Int(peoplePowerStrings);
        Arrays.sort(peoplePowerInt);
        // 经过搭配已经可以参加队伍的数组下标
        List<Integer> chosenIndexes = new ArrayList<>();
        int mostTeamCount = 0;
        for (int i = 0; i < peoplePowerInt.length; i++) {
            if(!chosenIndexes.contains(i)) {
                //这个下标的人还没被选走
                if(peoplePowerInt[i] >= minPower) {
                    mostTeamCount++;
                    chosenIndexes.add(i);
                } else {
                    for (int j = i+1; j < peoplePowerInt.length ; j++) {
                        if(!chosenIndexes.contains(j)) {
                            int totalPower = peoplePowerInt[i] + peoplePowerInt[j];
                            if(totalPower >= minPower){
                                mostTeamCount++;
                                chosenIndexes.add(i);
                                chosenIndexes.add(j);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return mostTeamCount;
    }

    private static int[] convertString2Int(String[] peoplePowerArray) {
        int[] result = new int[peoplePowerArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(peoplePowerArray[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        // TODO：输入老报错
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int arrayLength = Integer.parseInt(scanner.nextLine());
            String[] powers = scanner.nextLine().split(" ");
            int minPower = Integer.parseInt(scanner.nextLine());
            System.out.println(findMostTeam(arrayLength, powers, minPower));
        }
    }
}
