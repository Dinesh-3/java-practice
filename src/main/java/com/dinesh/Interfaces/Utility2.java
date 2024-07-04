package com.dinesh.Interfaces;

public interface Utility2 {
    String interfaceName = Utility2.class.getSimpleName();
    default void print(int a) {
        System.out.println(a);
    }
    int getName();
    static String getInterfaceName(){
        return interfaceName;
    }
}
