package org.example.zzb.bootcamp.c.concurrency;

public class RaceCondition {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread one = new Thread(counter, "one");
        Thread two = new Thread(counter, "two");
        Thread three = new Thread(counter, "three");
        Thread four = new Thread(counter, "four");
        Thread five = new Thread(counter, "five");

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
    }
}

class Counter implements Runnable {
    private int counter = 0;

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        this.increment();
        System.out.println(Thread.currentThread().getName()+" increments "+ getCounter());
        this.decrement();
        System.out.println(Thread.currentThread().getName()+" decrements "+ getCounter());
    }
}
