package com.dinesh.tricky;

public class Boxing {
    public static void main(String[] args) {
        Integer number = new Integer(12); // Boxing
        int primitive = number.intValue(); // Unboxing
        int autoUnbox = number; // Automatically Unboxing

        Integer updated = setIntValue(number);

        System.out.println("number = " + number.toString());
        System.out.println("updated = " + updated);

    }

    private static Integer setIntValue(Integer number) {
        number = 10;
        return number;
    }

}
