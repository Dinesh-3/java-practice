package temp;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.math.BigDecimal.ONE;

public class Temp {
    public static void main(String[] args) {
        double result = ONE.subtract(BigDecimal.valueOf(20000).divide(BigDecimal.valueOf(100.0))).doubleValue();
        System.out.println("result = " + result);

        Boolean eligible = null;

        if(eligible == FALSE)
            System.out.println("eligible = " + eligible);
        boolean isApplicable = eligible ? true: false;

    }
}
