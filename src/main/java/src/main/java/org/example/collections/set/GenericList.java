package org.example.collections.set;

import java.util.ArrayList;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.ListIterator;

public class GenericList<T> {

    public static void main(String[] args) {
        List<Integer> alist = new ArrayList<>();
        alist.add(1);
        alist.add(2);
        alist.add(2);
        ListIterator<Integer> li = alist.listIterator();
        System.out.println(li.next());
        System.out.println(li.next());
        System.out.println(li.previous());

    }
}
