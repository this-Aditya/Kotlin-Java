package org.example.zzb.bootcamp.c.concurrency.unstructured;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockTryLocking {
    public static void main(String[] args) {
        MyCounter counter = new MyCounter();
        Thread one = new Thread(counter, "one");
        Thread two = new Thread(counter, "two");
        Thread three = new Thread(counter, "three");
        Thread four = new Thread(counter, "four");
        Thread five = new Thread(counter, "five");

        MyCounter counter2 = new MyCounter();
        Thread ct = new Thread(counter2, "counter thread");

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        ct.start();
    }
}

class MyCounter implements Runnable {
    private int counter = 0;
    private Lock lock = new ReentrantLock();


    void increment() {
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        counter++;
    }

    void decrement() {
        counter--;
    }

    int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        if (lock.tryLock()) {
            try {
                this.increment();
                System.out.println(Thread.currentThread().getName() + " increments " + getCounter());
                this.decrement();
                System.out.println(Thread.currentThread().getName() + " decrements " + getCounter());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName()+" just not tried the lock...");
        }
    }
}
