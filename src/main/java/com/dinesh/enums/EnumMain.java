package enums;

import java.util.Arrays;

public class EnumMain {
    public static void main(String[] args) {
        Genre action = Genre.ACTION;
        System.out.println("action = " + action);

        DayOfWeek monday = DayOfWeek.MONDAY;
        System.out.println("monday = " + monday);
        System.out.println("monday.getClass().getMethods() = " + Arrays.toString(monday.getClass().getMethods()));
    }
}
