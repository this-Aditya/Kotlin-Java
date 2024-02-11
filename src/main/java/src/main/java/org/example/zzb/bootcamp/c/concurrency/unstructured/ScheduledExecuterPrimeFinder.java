package org.example.zzb.bootcamp.c.concurrency.unstructured;

import org.example.zzb.bootcamp.c.concurrency.PrimeNumberUtil;

import java.util.Scanner;
import java.util.concurrent.*;

public class ScheduledExecuterPrimeFinder {

    public static void main(String[] args) {
        findPrimeEfficiently();
    }

    static void findPrimeEfficiently() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledES = Executors.newScheduledThreadPool(1);

        Runnable reporterRunnable = () -> {
            System.out.println("\nActive Threads: " + executorService.getActiveCount());
            System.out.println("Completed Threads: " + executorService.getCompletedTaskCount());
        };
        scheduledES.scheduleAtFixedRate(reporterRunnable, 1, 5, TimeUnit.SECONDS);

        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.print("\nI can tell you nth prime number, enter the n...");
            int n = s.nextInt();
            if (n == 0) {// Entering 0 is the exit condition!!
                System.out.println("Not taking further responses--completing");
                break;
            }
            ;

            Runnable run = () -> {
                int num = PrimeNumberUtil.calculatePrime(n);
                System.out.println("The " + n + "th prime number is " + num);
            };
            executorService.execute(run);
        }
    }
}
