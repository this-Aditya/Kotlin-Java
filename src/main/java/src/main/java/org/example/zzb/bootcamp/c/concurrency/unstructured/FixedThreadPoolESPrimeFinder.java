package org.example.zzb.bootcamp.c.concurrency.unstructured;

import org.example.zzb.bootcamp.c.concurrency.PrimeNumberUtil;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This code will just provide 3 thread at a time:
// Fir better understanding of this code this can be taken as input ->
// 30000, 30000, 30000, 2, 3, 4
// and output will be:
//The 30000th prime number is 350377
//The 2nd prime number is 3
//The 4th prime number is 7
//The 5th prime number is 11
//The 30000th prime number is 350377
//The 30000th prime number is 350377
public class FixedThreadPoolESPrimeFinder {
    public static void main(String[] args) {
     EfficientPrimeFinder epf = new EfficientPrimeFinder();
     epf.findPrimeEfficiently();
    }
}

class EfficientPrimeFinder {
    void findPrimeEfficiently() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.print("\nI can tell you nth prime number, enter the n...");
            int n = s.nextInt();
            if (n == 0) {// Entering 0 is the exit condition!!
                System.out.println("Not taking further responses--completing");
                break;
            };

            Runnable run = () -> {
                int num = PrimeNumberUtil.calculatePrime(n);
                System.out.println("The " +n+"th prime number is "+num);
            };
            executorService.execute(run);
        }
    }
}
