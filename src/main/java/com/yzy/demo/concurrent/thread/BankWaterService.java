package com.yzy.demo.concurrent.thread;

import com.yzy.demo.concurrent.thread.util.ThreadUtils;
import com.yzy.demo.util.SleepUtils;

import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * CyclicBarrier 使用场景
 *
 * @author young
 * @date 2019/8/7 16:22
 */
public class BankWaterService implements Runnable {
    /**
     * 创建4个屏障，处理完成后执行当前类的run方法
     */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4,this);

    private ExecutorService bankWaterPool = ThreadUtils
            .createThreadPool(4,"bankWater");

    private ConcurrentHashMap<String,Integer> sheetBankWaterCount =
            new ConcurrentHashMap<>();

    private void count() {
        IntStream.range(0,4).forEach(i-> bankWaterPool.execute(() -> {
            //计算当前sheet的流水数据
            SleepUtils.second(2);
            sheetBankWaterCount.put(Thread.currentThread().getName(),1);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }));
        bankWaterPool.shutdown();
    }


    @Override
    public void run() {
        int result = 0;
        //汇总每个sheet的计算结果
        for(Map.Entry<String,Integer> entry: sheetBankWaterCount.entrySet()){
            result+=entry.getValue();
            System.out.println(entry.getKey());
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
