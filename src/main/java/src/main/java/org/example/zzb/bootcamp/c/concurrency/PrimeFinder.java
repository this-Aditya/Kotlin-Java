package org.example.zzb.bootcamp.c.concurrency;

import java.util.ArrayList;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.Scanner;

public class PrimeFinder {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Thread.currentThread().setName("\nMain Thread");
        threads.add(Thread.currentThread());
        threads.add(new Thread("Created Thread!"));
        Thread statusTracker = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    for (Thread thread : threads) {
                        System.out.println(thread.getName() + ": " + thread.getState());
                    }
                } catch (InterruptedException e) {
                    System.out.println("\nThread: " + Thread.currentThread().getName() + ", Interrupted!!");
                }
            }
        }, "Status Tracker");
        threads.add(statusTracker);
        statusTracker.setDaemon(true);
        statusTracker.start();
        efficientPrimeFinder(threads);
    }
    public static void efficientPrimeFinder(List<Thread> threads) {

        int i = 0;

        Thread joinThread = new Thread("Join Thread");
        while(true) {
            Scanner s = new Scanner(System.in);
            System.out.print("\nI can tell you nth prime number, enter the n...");
            int n = s.nextInt();
            if (n == 0) break; // Entering 0 is the exit condition!!
            i++;
            Thread th = new Thread(() -> {
                    int number = PrimeNumberUtil.calculatePrime(n);
//                    if (Thread.currentThread().getName().equals("Thread:3")) {
//                        threads.get(threads.size() - 2).interrupt();
//                    }
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\nResult from thread: "+Thread.currentThread().getName()+". "+n+"th prime number: "+ number+".");
            }, "Thread:"+i);
            th.setDaemon(true);
            threads.add(th);
            th.start();
        }
        try {
            threads.get(0).join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void inefficientPrimeFinder() {
        int number;

        while(true) {
            Scanner s = new Scanner(System.in);
            System.out.print("\nI can tell you nth prime number, enter the n...");
            int n = s.nextInt();
            if (n == 0) break; // Entering 0 is the exit condition!!
            number = PrimeNumberUtil.calculatePrime(n); // Super inefficient!!
            System.out.println("Value of "+n+"th prime number is "+ number+".");
        }
    }
}
