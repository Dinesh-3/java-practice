package com.dinesh.enums;

import java.util.Arrays;

public class EnumMain {
    public static void main(String[] args) {
        Genre action = Genre.ACTION;
        String genre = action.getGenre();

        System.out.println("genre = " + genre);
        System.out.println("action = " + action);
//        new stream.Gender("Action"); // Enum types cannot be instantiated
        System.out.println("action.getUniqueName() = " + action.getUniqueName());

        DayOfWeek monday = DayOfWeek.MONDAY;
        System.out.println("monday = " + monday);
        System.out.println("monday.getClass().getMethods() = " + Arrays.toString(monday.getClass().getMethods()));
    }
}
