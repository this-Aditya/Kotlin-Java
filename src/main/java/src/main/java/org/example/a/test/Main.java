//package org.example.a.test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class Main {
//    public static void main(String[] args) {
//        Set<Device> paired = new HashSet<>();
//        paired.add(new Device("Realme Buds", true));
//        paired.add(new Device("Ford", true));
//        paired.add(new Device("Zebronics", true));
//
//        Set<Device> newelyPaired = new HashSet<>();
//        paired.add(new Device("Realme Buds", true));
//        paired.add(new Device("Zebronics", true));
//        paired.add(new Device("One plus bolt", true));
//
//        Set<Device> devicesToUpdate = paired - newelyPaired
//
//    }
//}
//
//class Device {
//    String name;
//    boolean isPaired;
//    public Device(String name, boolean isPaired) {
//        this.name = name;
//        this.isPaired = isPaired;
//    }
//}
//
