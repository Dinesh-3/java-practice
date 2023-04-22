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
     *  if change in method param no problem
     *  but change in return type will not prevent error
     */
//    default int hashCode(){ // equals, toString, clone, wait,notify, notifyAll, getClass, finalize
//        return 234234;
//    };

    // Won't throw error
    default String hashCode(String word){ // equals, toString, clone, wait,notify, notifyAll, getClass, finalize
        return "234234";
    };

    static String getAny(){return "";};

    static String gedfstAny(){return "";}



}
