package com.dinesh.tricky;

 interface Syrupable {
 void getSugary();
 }
 abstract class Pancake implements Syrupable {
     private static int field = 1;

     private static int getField() {
         return field;
     };

 }

class BlueBerryPancake extends Pancake {
    @Override
    public void getSugary() {

    } // implements Pancake throws error
 }

 class SourdoughBlueBerryPancake extends BlueBerryPancake {
     void getSugary(int s) { ; }
 }

 public class Abstract {
}
