package org.example.zzb.bootcamp.c.concurrency;

public class PrimeNumberUtil {

    public static int calculatePrime(int n) {
        int number = 1;
        int numberOfPrimesFound = 0;
        int i;

        while (numberOfPrimesFound < n) {
            number++;
            i = 2;
            while ((i<=number) && (number%i!=0)) {
                i++;
            }
            if (i==number) {
                numberOfPrimesFound++;
            }
        }
        return number;

    }
}
