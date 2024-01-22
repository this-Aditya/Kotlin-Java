package org.example.zzb.bootcamp.c.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyNeed {

    static int count = 0;
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable rn = () -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 100000; i++) {
                    try {
                        count++;
                    } finally {
                    }
                }
            lock.unlock();
        };
        Thread one = new Thread(rn, "one");
        Thread two = new Thread(rn, "two");
        Thread three = new Thread(rn, "three");
        Thread four = new Thread(rn, "four");
        Thread five = new Thread(rn, "five");

        List<Thread> threads = new ArrayList<>(5);
        threads.add(one);
        threads.add(two);
        threads.add(three);
        threads.add(four);
        threads.add(five);

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Counted nums: " + count);
    }
}
