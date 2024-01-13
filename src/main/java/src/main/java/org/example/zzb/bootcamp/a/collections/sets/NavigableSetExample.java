package org.example.zzb.bootcamp.a.collections.sets;

import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {
    public static void main(String[] args) {
        NavigableSet<LocalDateTime> appointments = new TreeSet<>();

        appointments.add(LocalDateTime.of(2023, 10, 4, 4, 30));
        appointments.add(LocalDateTime.of(2023, 10, 4, 3, 30));
        appointments.add(LocalDateTime.of(2023, 10, 4, 3, 0));
        appointments.add(LocalDateTime.of(2023, 10, 4, 3, 0));
        appointments.add(LocalDateTime.of(2023, 10, 4, 5, 30));
        appointments.add(LocalDateTime.of(2023, 10, 4, 4, 0));
        appointments.add(LocalDateTime.of(2023, 10, 4, 5, 0));
        appointments.add(LocalDateTime.of(2023, 10, 4, 6, 0));

        System.out.println("appointments: "+ appointments.higher(LocalDateTime.of(2023, 10, 4, 4, 0)));
        System.out.println("appointments: "+ appointments.lower(LocalDateTime.of(2023, 10, 4, 4, 0)));
        System.out.println("appointments: "+ appointments.ceiling(LocalDateTime.of(2023, 10, 4, 3, 58)));
        System.out.println("appointments: "+ appointments.floor(LocalDateTime.of(2023, 10, 4, 3, 58)));


    }
}
