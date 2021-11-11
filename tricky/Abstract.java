package tricky;

 interface Syrupable {
 void getSugary();
 }
 abstract class Pancake implements Syrupable { }

class BlueBerryPancake extends Pancake { // implements Pancake throws error
     public void getSugary() { ; }
 }

 class SourdoughBlueBerryPancake extends BlueBerryPancake {
     void getSugary(int s) { ; }
 }

 public class Abstract {
}
