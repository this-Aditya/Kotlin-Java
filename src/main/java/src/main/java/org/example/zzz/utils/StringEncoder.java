package org.example.zzz.utils;

public class StringEncoder {
    public static void main(String[] args) {
        String str = "{\"time\":0.0,\"timeReceived\":0.0,\"bloodVolumePulse\":0.0}";
        byte[] arr = str.getBytes();
        for (byte b: arr)
        {
            System.out.print(b+ " ");
        }
        System.out.println();

        byte[] b = "a".getBytes();
//        byte x = 97;
//        System.out.println((char) x);
        for (byte ba: b)
        {
            System.out.print(ba+ " ");
        }
    }
}




