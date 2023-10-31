package org.example.b.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoxDemo {

    public static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBox(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {
        List<Box<String>> boxes = new ArrayList<>();
//        List<Box<Integer>> boxes = new ArrayList<Box<Integer>>();  Above one can also be represented in this way too.
        BoxDemo.<String> addBox("Laptop Box", boxes);
        BoxDemo.<String> addBox("Smartphone Box", boxes);
        BoxDemo.<String> addBox("Computer Box", boxes);

        BoxDemo.<String> outputBox(boxes);

        // Rough Work ---

        Map<String, List<String>> m1 = new HashMap<String, List<String>>();
        Map<String, List<String>> m2 = new HashMap<>();
        Map<String, List<String>> m3 = new HashMap(); // Unchecked assignment: 'java.util.HashMap' to 'java.util.Map<java.lang.String,java.util.List<java.lang.String>>'
    }
}
