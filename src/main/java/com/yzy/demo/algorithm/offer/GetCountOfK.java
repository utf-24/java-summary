package com.yzy.demo.algorithm.offer;

/**
 * 剑指offer 53
 * @author yangzyh
 * @date 2021/8/6 21:30
 */
public class GetCountOfK {

    int getNumberOfK(int[] data, int k) {
        int count = 0;
        int first = getFirstOfK(data, 0, data.length-1, k);
        int last = getLastOfK(data, 0, data.length-1, k);
        if(first > -1 && last > -1) {
            count = last - first +1;
        }

        return count;
    }

    private int getLastOfK(int[] data, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (end + start) / 2;
        if(data[middleIndex] == k) {
            if ((middleIndex < data.length - 1 && data[middleIndex + 1] != k) ||
                    middleIndex == data.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex +1;
            }
        }
        else if(data[middleIndex] > k) {
            end = middleIndex-1;
        } else {
            start = middleIndex +1;
        }
        return getLastOfK(data, start, end, k);
    }

    private int getFirstOfK(int[] data, int start, int end, int k) {
        if(start > end) {
            return -1;
        }
        int middleIndex = (end + start)/ 2;
        if(data[middleIndex] == k) {
            if((middleIndex > 0 && data[middleIndex-1] != k) ||
                    middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex-1;
            }
        }
        else if (data[middleIndex] > k) {
            end = middleIndex -1;
        } else {
            start = middleIndex +1;
        }

        return getFirstOfK(data, start, end, k);
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,3,3,3,4,5};
        System.out.println(new GetCountOfK().getNumberOfK(data, 3));
    }
}
