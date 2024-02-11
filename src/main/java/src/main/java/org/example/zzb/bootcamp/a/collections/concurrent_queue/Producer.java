package org.example.zzb.bootcamp.a.collections.concurrent_queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private int id;
    private BlockingQueue<Item> queue;
    Random random = new Random();

    public Producer(int id, BlockingQueue<Item> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Item item = new Item(i);
            try {
                System.out.printf("Producer %d produced %d%n", id, item.getId());
                queue.put(item);
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            queue.put(new Item(-1));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
