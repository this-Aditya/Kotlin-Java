package org.example.zzb.bootcamp.a.collections.concurrent_queue;

import java.util.concurrent.SynchronousQueue;

public class TwoThreadSyncQ {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> synq = new SynchronousQueue<>();
        new Thread(() -> {
            System.out.println("Trying to take element");
            String element = null;
            try {
                element = synq.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Took element: "+ element);
        }).start();
        new Thread(() -> {
            try {
                System.out.println("Adding element after 4 seconds!!");
                Thread.sleep(4000);
                synq.put("Hello sync ");
                System.out.println("Added element from thread: "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
