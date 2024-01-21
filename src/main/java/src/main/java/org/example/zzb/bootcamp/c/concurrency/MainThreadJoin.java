package org.example.zzb.bootcamp.c.concurrency;

/**
 * This will cause the program to run infinitely as the statement <b>th.join</b> will only execute when  the main
 * thread completes it execution, but that will never complete before this statement is approached
 */
public class MainThreadJoin {
    public static void main(String[] args) {
        System.out.println("Joining On Main thread");
        Thread th = Thread.currentThread();
        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed join");
    }
}
