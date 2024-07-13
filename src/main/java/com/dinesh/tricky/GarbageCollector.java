package com.dinesh.tricky;

import com.dinesh.object.Dog;
import java.lang.System;

public class GarbageCollector {
    public static void main(String[] args) {
        var puppy =  new Dog("Puppy");
        var twinky =  new Dog("Twinky");

        System.out.println(puppy);
        puppy = null;
        System.gc();

        System.out.println(twinky);
        twinky = null;

        Runtime.getRuntime().gc();

    }
}
