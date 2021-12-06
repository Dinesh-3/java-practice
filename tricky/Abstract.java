package tricky;

 interface Syrupable {
 void getSugary();
 }
 abstract class Pancake implements Syrupable { }

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
