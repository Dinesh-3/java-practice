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

    public static void objectRelation(String[] args) {
        /**
         *  is a -> Dog IS A Animal (Dog inherits animal)
         *  has a -> Car HAS Driver
         *  Association (Has A) Relationship between two objects
         *   Types:
         *      1. Aggregation:
         *          Loosely coupled both objects can work independently
         *          example Car has Driver, Team Has Player, Player Has Ball
         *      2. Composition:
         *          Tightly coupled can't be run one without other
         *          Example: Car Has Engine (
         *          Car can't run without engine,
         *          Engine can't exist without a car
         *          )
         */
    }
}
