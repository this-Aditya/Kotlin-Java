package org.example.zzb.bootcamp.a.collections.concurrent_queue;

import java.util.concurrent.SynchronousQueue;

public class FailedSyncQ {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> syncq = new SynchronousQueue<>();
        System.out.println("Before the remove statement");
//        new Thread (() -> {
//            try {
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
        syncq.put("Hello First");
        syncq.take(); // WIll stuck here as only one thread is adding the element to this!!
        System.out.println("After the remove statement");
    }
}
