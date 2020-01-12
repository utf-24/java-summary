    package com.yzy.demo.algorithm;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    /**
     * 有一种奇怪的计算机，它的内存是由若干位组成的（初始都是0），并且它只能进行如下操作：
     * 选择某一位和一个值（0或1），从选中的位开始到最后一位的值都会被改成选定的值。比如，当前内存为“0010”，若选择第二位和值1，那么内存将会被改成“0111”。
     * 现在要你将内存从初始状态改成某个特定的序列A，最少需要多少次操作呢？
     *
     * 输入
     * 一行，一个由“0”和“1”组成的字符串，表示特定序列A
     *
     * 输入约束
     * 序列A中仅包含字符0或1，且字符个数（内存大小）范围是 [1,50]
     *
     * 输出
     * 一行，一个整数，表示为了得到这个序列最少需要的操作次数
     *
     * 例子
     * 输入
     * 0011
     * 输出
     * 1
     * @author young
     * @date 2019/9/30 9:06
     */
    public class StrangeComputer {
        static int getMinOperation(String str){
            char[] array = str.toCharArray();

            // 统计整个输入序列中后一位与前一位不同的次数
            int diff = 0;
            for(int i = 0; i<array.length;i++){
                if(i==0){
                    // 首位是1的情况也加入统计
                    if(array[i]=='1'){
                        diff++;
                    }
                    continue;
                }
                if(array[i]!=array[i-1]){
                    diff++;
                }
            }

            return diff;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine().trim();
            System.out.println(getMinOperation(str));
        }
    }
