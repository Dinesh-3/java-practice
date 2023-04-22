package operators;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    private static final DecimalFormat format = new DecimalFormat();
    public static void main(String[] args) {
        double price = 6.7888;
        double rounded = roundOf(price, 2);
        System.out.println("rounded = " + rounded);
        double floatAdded = 0.2 + 0.1;
        System.out.println("floatAdded = " + floatAdded);
        System.out.println( floatAdded == 0.3); // false

        BigDecimal.valueOf(10_000);

    }

    public static double roundOf(double number, int round){
        String pattern = "#." + "#".repeat(Math.max(0, round));
        format.applyPattern(pattern);
        String fixedFloat = format.format(number);
        return Double.parseDouble(fixedFloat);
    }

}
