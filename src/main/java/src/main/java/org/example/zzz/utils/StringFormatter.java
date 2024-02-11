package org.example.zzz.utils;

public class StringFormatter {
    public static void main(String[] args) {
        String str = String.format("%02x", 26 & 0xff );
        System.out.println(str);
        byte b = -1;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(b & 0xff);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader.getName());
        System.out.println("Done");
    }
}
