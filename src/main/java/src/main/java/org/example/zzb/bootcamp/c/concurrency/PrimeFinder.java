package org.example.zzb.bootcamp.c.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program explains the functions of threads efficiently.
 * For clear concepts, provide input in the following format:
 *
 * @Thread_1 --30000
 * @Thread_2 --20000
 * @Thread_3 --20000
 * @Thread_4 --20000
 * @Thread_5 --20000
 *
 * @join Just take special care while using join,
 * as in this case don't forgot to expel <b>Main</b> and <b>Status-Tracker</b> thread as they will not
 * be terminated automatically, they just can be terminated automatically. That's why we are only joining for the
 * threads which can be terminated automatically.
 */

public class PrimeFinder {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Thread.currentThread().setName("Main Thread");
        threads.add(Thread.currentThread());
        threads.add(new Thread("Created Thread!"));
        // One way to stop the thread when the main application thread completes its execution is
        // making this thread a Deamon thread. Other way is just to interrupt it.
        Thread statusTracker = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    for (Thread thread : threads) {
                        if (thread.getName().equals("Main Thread")) {
                            System.out.println("\n"+thread.getName() + ": " + thread.getState());
                            continue;
                        }
                        System.out.println(thread.getName() + ": " + thread.getState());
                    }
                } catch (InterruptedException e) {
                    System.out.println("\nStatus Tracker thread interrupted, stopping it!!");
                }
            }
        }, "Status Tracker");
        threads.add(statusTracker);
//        statusTracker.setDaemon(true)
        statusTracker.start();
        efficientPrimeFinder(threads);
    }

    public static void efficientPrimeFinder(List<Thread> threads) {

        int i = 0;

//        Thread joinThread = new Thread("Join Thread");
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.print("\nI can tell you nth prime number, enter the n...");
            int n = s.nextInt();
            if (n == 0) {// Entering 0 is the exit condition!!
                System.out.println("Not taking further responses--Waiting for remaining work to complete");
                waitForThreads(threads);
                break;
            }
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
                System.out.println("\nResult from thread: " + Thread.currentThread().getName() + ". " + n + "th prime number: " + number + ".");
            }, "Thread:" + i);
            th.setDaemon(true);
            threads.add(th);
            th.start();
        }
    }

    private static void waitForThreads(List<Thread> threads) {
        int i = 0;
        for (Thread th: threads) {
            if (th.getName().equals("Status Tracker") || th.getName().equals("Main Thread")){
                System.out.println("Skipping joins for thread:  "+th.getName());
                i++;
//                threads.removeIf(thread -> thread.getName().equals("Main Thread")); // Will through ConcurrentModificationException
                continue;
            }
            try {
                System.out.println("Joining thread: "+ th.getName()+" --");
                th.join();
                i++;
                System.out.println("Completed work for thread: "+ th.getName());
                if (i == threads.size()) {
                    Thread threadToInterrupt = threads.stream()
                            .filter(thread -> thread.getName().equals("Status Tracker"))
                            .findFirst().orElse(null);
                    if (threadToInterrupt != null) {
                        threadToInterrupt.interrupt();
                    } else {
                        System.out.println("Got null");
                    }
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void inefficientPrimeFinder() {
        int number;

        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.print("\nI can tell you nth prime number, enter the n...");
            int n = s.nextInt();
            if (n == 0) break; // Entering 0 is the exit condition!!
            number = PrimeNumberUtil.calculatePrime(n); // Super inefficient!!
            System.out.println("Value of " + n + "th prime number is " + number + ".");
        }
    }
}