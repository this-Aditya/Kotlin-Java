package org.example.zzb.bootcamp.a.collections.concurrent_queue;

import java.util.concurrent.SynchronousQueue;

public class RealSyncQ {
    public static void main(String[] args) {
        SynchronousQueue<String> sq = new SynchronousQueue<>();
        System.out.println("Starting of the program!!");
        new Thread(() -> {
            try {
                System.out.println("Adding first element!!");
                sq.put("First");
                System.out.println("Adding second element");
                sq.put("Second");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("Retrieving first element");
                String  first = sq.take();
                System.out.println("Element retrieved: "+ first);
                System.out.println("Retrieving second element");
                String second = sq.take();
                System.out.println("Element retrieved: "+ second);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
