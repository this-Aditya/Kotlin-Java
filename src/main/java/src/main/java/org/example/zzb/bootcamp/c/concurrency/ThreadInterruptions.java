package org.example.zzb.bootcamp.c.concurrency;

public class ThreadInterruptions {

    public static void main(String[] args) {
    Thread th = new Thread(() -> {
        System.out.println(PrimeNumberUtil.calculatePrime(30000));
    });
    th.start();
    System.out.println("Trying to interrupt thread");
    th.interrupt();
    //above statement will eventually have no effect as thread.interrupt only
    //works for wait(), sleep() and @join() overloads

    }
}
