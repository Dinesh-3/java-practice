package Interfaces;

import tricky.ImmutableUser;

public interface Utility1 {

    public static String interfaceName = Utility1.class.getSimpleName();
    int totalMethods = Utility1.class.getMethods().length;

    default void print(int a) {
        System.out.println(a);
    }

    int getName();

    /**
     * Throws error we can't create default methods for object class
     * Default method 'hashCode' overrides a member of 'java.lang.Object
     *
     */
//    default int hashCode(){ //
//        return 234234;
//    };
}
