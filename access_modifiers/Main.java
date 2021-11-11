package access_modifiers;

import inheritance.Entity;

/**
 * Related with inheritance folder
 */
public class Main {
    public String instanceField = "";
//    public static String staticField = instanceField; // Non-static field 'above' cannot be referenced from a static context

    public static void main(String[] args) {
        Entity entity = new Entity();
//        entity.getProtectedField(); // throw's error
        Manager manager = new Manager();
        manager.getProtectedField();
    }
}
