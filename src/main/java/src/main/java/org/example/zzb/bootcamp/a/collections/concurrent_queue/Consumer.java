package org.example.zzb.bootcamp.a.collections.concurrent_queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private int id;
    private BlockingQueue<Item> queue;
    Random random = new Random();

    public Consumer(int id, BlockingQueue<Item> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        Item item;
        try {
            Item msg = new Item(10);
            while ((msg).getId() != -1) {
                 msg = queue.take();

                System.out.printf("Consumer %d consumed %d%n", id, msg.getId());

                Thread.sleep(random.nextInt(100));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
