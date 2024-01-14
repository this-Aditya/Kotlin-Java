package org.example.zzb.bootcamp.a.collections.concurrent_queue;


import java.util.concurrent.SynchronousQueue;

public class PassedSyncQ {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> syncq = new SynchronousQueue<>();
        System.out.println("Before the put and take statements");

        new Thread(() -> {
            try {
                syncq.put("Hello First");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                String element = syncq.take();
                System.out.println("Received: " + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Give some time for the threads to execute
        Thread.sleep(1000);

        System.out.println("After the put and take statements");
    }
}

