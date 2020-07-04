package com.yzy.demo.concurrent.jcip.chapter7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 7-2 p113
 * 一个可取消的任务，枚举素数
 *
 * @author yangzyh
 * @date 2020/6/6 11:09
 */
public class PrimeGenerator implements Runnable{

    public final List<BigInteger>  primes = new ArrayList<BigInteger>();

    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel(){
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    private List<BigInteger> aSecondOfPrimes() {
        var primeGenerator = new PrimeGenerator();
        new Thread(primeGenerator).start();
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            primeGenerator.cancel();
        }

        return primeGenerator.get();
    }

    public static void main(String[] args) {
        var primeGenerator = new PrimeGenerator();
        System.out.println(primeGenerator.aSecondOfPrimes());
    }
}
