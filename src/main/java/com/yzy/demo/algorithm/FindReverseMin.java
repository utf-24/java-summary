package com.yzy.demo.algorithm;

/**
 * find min val in a reverse ordered array
 * e.g. 3,4,5,1,2 --> find 1
 *      1,0,1,1,1 --> find 0
 *
 * @author young
 * @date 2019/9/12 13:37
 */
public class FindReverseMin {

    public int find(int[] src) throws Exception {
        if(src == null || src.length == 0) {
            throw new Exception("invalid parameters");
        }
        int indexLeft = 0;
        int indexRight = src.length-1;
        int indexMid = 0;

        while(src[indexLeft]>=src[indexRight]){
            if(indexRight-indexLeft == 1){
                return src[indexRight];
            }
            indexMid = (indexLeft+indexRight)/2;
            if(src[indexLeft] == src[indexMid] && src[indexMid] == src[indexRight]){
                return findInOrder(src);
            }
            if(src[indexMid] >= src[indexLeft]){
                // find in right subArray
                indexLeft = indexMid;
            }else{
                // find in left subArray
                indexRight = indexMid;
            }
        }

        return src[indexMid];
    }

    private int findInOrder(int[] src) {
        int ret = src[0];
        for(int item: src) {
            if(ret>item){
                ret = item;
            }
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        FindReverseMin findReverseMin = new FindReverseMin();
        int[] array = {3,4,5,1,2};
        System.out.println(findReverseMin.find(array));
        array = new int[]{1, 0, 1, 1, 1};
        System.out.println(findReverseMin.find(array));
    }

}
