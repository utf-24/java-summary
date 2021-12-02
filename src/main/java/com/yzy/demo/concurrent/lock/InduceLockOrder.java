package com.yzy.demo.concurrent.lock;

import java.util.Comparator;

/**
 * InduceLockOrder
 *
 * Inducing a lock order to avoid deadlock
 *
 * @author Brian Goetz and Tim Peierls
 */
public class InduceLockOrder {
    public static final Object tieLock = new Object();

    public void transferMoney(final Account fromAccount, final  Account toAccount, final DollarAmount amount)
            throws InsufficientFoundsException {
        class Helper {
            public void transfer() throws InsufficientFoundsException {
                if(fromAccount.getBalance().compareTo(amount) <0) {
                    throw new InsufficientFoundsException();
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);
        if(fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        } else if(fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (toAccount) {
                    synchronized (fromAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }

    }

    interface DollarAmount extends Comparable<DollarAmount> {

    }

    interface Account {
        void debit(DollarAmount d);

        void credit(DollarAmount d);

        DollarAmount getBalance();
    }

    private class InsufficientFoundsException extends Exception {

    }
}
