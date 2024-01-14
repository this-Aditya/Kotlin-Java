package org.example.zzb.bootcamp.a.collections.concurrentmaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConcurrentMap {

    public static void main(String[] args) {
        Map<String, Integer> hashmap = new HashMap<>();
        Map<String, Integer> syncMap = Collections.synchronizedMap(hashmap);

        ConcurrentRunnable1 cr1 = new ConcurrentRunnable1(syncMap);
        ConcurrentRunnable2 cr2 = new ConcurrentRunnable2(syncMap);
        ConcurrentRunnable3 cr3 = new ConcurrentRunnable3(syncMap);
        ConcurrentRunnable4 cr4 = new ConcurrentRunnable4(syncMap);

        System.out.println("main: "+ Thread.currentThread().getName());

        try {
            for (Map.Entry<String, Integer> e : syncMap.entrySet()) {
                System.out.println(e.getKey() + "=" + e.getValue());
            }
        } catch(Exception e) {
            System.out.println("Thread: "+Thread.currentThread().getName());
            e.printStackTrace();
        }
    }
}


class ConcurrentRunnable1 implements Runnable {
    Map<String, Integer> map;
    Thread thread;

    public ConcurrentRunnable1(Map<String, Integer> map) {
        this.map = map;
        thread = new Thread(this, "first");
        thread.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("MapHelper1 sleeping "+ Thread.currentThread().getName());
            Integer x = map.put("One", 1);
            System.out.println("MapHelper1 Waking: "+ x);
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + e);
        }
    }
}


class ConcurrentRunnable2 implements Runnable {
    Map<String, Integer> map;
    Thread thread;


    public ConcurrentRunnable2(Map<String, Integer> map) {
        this.map = map;
        thread = new Thread(this, "Second");
        thread.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("MapHelper2 sleeping: "+ Thread.currentThread().getName());
            Integer y = map.put("Two", 2);
            System.out.println("MapHelper2 Waking: "+ y);
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + e);
        }
    }
}

class ConcurrentRunnable3 implements Runnable {
    Map<String, Integer> map;
    Thread thread;


    public ConcurrentRunnable3(Map<String, Integer> map) {
        this.map = map;
        thread = new Thread(this, "Third");
        thread.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("MapHelper3 sleeping: " + Thread.currentThread().getName());
            Integer z = map.put("Three", 3);
            System.out.println("MapHelper3 Waking: "+z);
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + e);
        }
    }
}

class ConcurrentRunnable4 implements Runnable {
    Map<String, Integer> map;
    Thread thread;


    public ConcurrentRunnable4(Map<String, Integer> map) {
        this.map = map;
        thread = new Thread(this, "Fourth");
        thread.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("MapHelper4 sleeping: "+ Thread.currentThread().getName());
            Integer a = map.put("Fourth", 4);
            System.out.println("MapHelper4 Waking: "+ a);
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + e);
        }
    }
}