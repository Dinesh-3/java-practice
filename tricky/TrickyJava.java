package tricky;

import object.Animal;
import object.Cat;
import object.Dog;

import java.util.List;

/*
    Marker Interface -> Marker Interface are interface without any method declaration,
        To tell metadata to JVM
    Ex. Serializable, Cloneable
 */

public class TrickyJava {
    public static void main(String[] args) {
        var dog = new Dog("Puppy");
        var cat = new Cat("Cat");
        var cat1 = new Cat("Cat");

        if(cat1.equals(cat)) System.out.println(cat.hashCode()+" EQUula " + cat1.hashCode());

        /*
            while overriding a method in subclass
            we change return type to its subclass like below
            in this demo Object is the parent of all others, so we can use any return type
         */

        String dogSound = dog.MakeSound();
        Object catSound = cat.MakeSound();

        List<Animal> animals = List.of(dog, cat );


        var index = 0;
        for(var animal: animals) {
            Object sound = animal.MakeSound();
            if( sound instanceof String ) {
                String casted = (String) animal.MakeSound();
                System.out.println("STRING CASTED: " + casted.toUpperCase());
                continue;
            }
//            System.out.println("CALLED");
            if( sound instanceof Number ) {
                Number casted = (Number) animal.MakeSound();
                System.out.println("Number CASTED: " + casted.floatValue());
            }
            ++index;
        }
        System.out.println("index = " + index);

    }
}
