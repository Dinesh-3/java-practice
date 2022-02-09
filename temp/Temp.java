package temp;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;

public class Temp {
    public static void main(String[] args) {
        double result = ONE.subtract(BigDecimal.valueOf(20000).divide(BigDecimal.valueOf(100.0))).doubleValue();
        System.out.println("result = " + result);
    }
}
