package com.dinesh.OOP;

import com.dinesh.object.Person;

import java.time.LocalDate;

/**
 *
 * INSTANCE METHOD:
 *  Memory allocation: These methods themselves are stored in Permanent Generation space of heap but the parameters (arguments passed to them) and their local variables and the value to be returned are allocated in stack.
 *  They can be called within the same class in which they reside or from the different classes defined either in the same package or other packages depend on the access type provided to the desired instance method.
 * STATIC METHOD:
 *  They are stored in the Permanent Generation space of heap as they are associated with the class in which they reside not to the objects of that class.
 *  But their local variables and the passed argument(s) to them are stored in the stack.
 *  Since they belong to the class, so they can be called to without creating the object of the class.
 */
public class OOPMain {
    public static void main(String[] args) {
        Person dinesh1 = new Person("Dinesh", "Iyyandurai", LocalDate.of(2000, 7, 25));
        Person dinesh2 = new Person("Dinesh", "Iyyandurai", LocalDate.of(2000, 7, 25));

        System.out.println("dinesh1 == dinesh2 = " + (dinesh1 == dinesh2));
        System.out.println("dinesh1.equals(dinesh2) = " + dinesh1.equals(dinesh2));

        int age = dinesh1.getAge();
        System.out.println("age = " + age);
    }
}
