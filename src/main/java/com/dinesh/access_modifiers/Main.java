package com.dinesh.access_modifiers;

import com.dinesh.inheritance.Entity;

/**
 * Related with inheritance folder
 *
 *  + => accessible , - -> not accessible , pkg -> package
 *
                    Class	    Package	    Subclass same pkg	Subclass diff pkg	World
     public	        +	        +	                +	                +	            +
     protected	    +	        +	                +	                +
     no modifier	+	        +	                +                   -               -
     private	    +           -                   -                   -               -
 */
public class Main {
    public String instanceField = "";
//    public static String staticField = instanceField; // Non-static field 'above' cannot be referenced from a static context

    public static void main(String[] args) {
        Entity entity = new Entity();
//        entity.getProtectedField(); // throw's error
        com.dinesh.access_modifiers.Manager manager = new Manager();
        String protectedField = manager.getProtectedField();
        System.out.println("protectedField = " + protectedField);

    }
}
