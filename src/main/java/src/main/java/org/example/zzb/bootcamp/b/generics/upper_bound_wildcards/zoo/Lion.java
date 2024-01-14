package org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo;

import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Eats;
import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Runs;
import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Sleeps;

public class Lion extends Animal implements Eats, Sleeps, Runs {
    String name = "Lion";

    @Override
    public void eat() {
    }

    @Override
    public void run() {

    }

    @Override
    public void sleep() {

    }
}
