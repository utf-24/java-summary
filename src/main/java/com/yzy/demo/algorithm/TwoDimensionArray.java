package com.yzy.demo.algorithm;

/**
 * 在二维数组找指定的值
 *
 * @author young
 * @date 2019/8/15 13:49
 */
public class TwoDimensionArray {
    static boolean IsExist(int[][] array, int value) {
        if(array.length == 0) {
            return  false;
        }
        int rows = array.length;
        int cols = array[0].length-1;
        int row = 0;
        while(cols >=0 && row<rows) {
            if(array[row][cols] == value){
                return true;
            }else if(array[row][cols] >value){
                cols--;
            }else{
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a ={{1,2,8,9},{2,4,9,12},{4,7,10,13}};

        boolean found = IsExist(a,1);
        System.out.println(found);

    }
}
