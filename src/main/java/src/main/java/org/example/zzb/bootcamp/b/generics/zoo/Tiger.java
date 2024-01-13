package org.example.zzb.bootcamp.b.generics.zoo;

import org.example.zzb.bootcamp.b.generics.zoo.activities.Eats;
import org.example.zzb.bootcamp.b.generics.zoo.activities.Runs;
import org.example.zzb.bootcamp.b.generics.zoo.activities.Sleeps;
import org.example.zzb.bootcamp.b.generics.zoo.activities.Swims;

public class Tiger extends Animal implements Eats, Sleeps, Runs, Swims {
    String name = "Tiger";

    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void swim() {

    }
}
