package access_modifiers;

import inheritance.Entity;

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
        access_modifiers.Manager manager = new access_modifiers.Manager();
        String protectedField = manager.getProtectedField();
        System.out.println("protectedField = " + protectedField);

    }
}
