package com.yzy.demo.algorithm.sort;

import java.util.HashMap;

/**
 * 两数之和
 * 给定一个目标值，在数组中找到两个数相加等于该目标
 *
 * @author young
 * @date 2019/8/10 22:32
 */
public class findTwoItemCount {

    /**
     *
     * O(n2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int length = nums.length;
        for (int index1 = 0; index1 < length - 1; index1++) {
            for (int index2 = index1 + 1; index2 < length; index2++) {
                if(nums[index1] + nums[index2] == target){
                    answer[0] = index1;
                    answer[1] = index2;
                    break;
                }
            }
        }
        return answer;
    }

    /**
     * 好机智。。。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

        return indexs;
    }

    public static int[] twoSum3(int[] nums, int target) {
        int max=2047;
        int temp;
        int[] test=new int[max+1];
        for(int i=0;i<nums.length;i++){


            temp=(target-nums[i])&max;
            if(test[temp]!=0){

                return new int[]{test[temp]-1,i};

            }
            test[nums[i]&max]=i+1;

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] answer = twoSum3(nums,target);
        System.out.println(answer[0]+", "+answer[1]);
     }
}
