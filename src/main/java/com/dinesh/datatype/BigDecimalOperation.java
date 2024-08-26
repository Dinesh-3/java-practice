package datatype;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static java.math.BigDecimal.ONE;

/**
 * BigDecimal
 * 1. Immutable
 */
public class BigDecimalOperation {
    public static void main(String[] args) {

        bigInteger();

        bigDecimal();

    }

    private static void bigInteger() {
        BigInteger largeNumber = new BigInteger("1234567890123456789012345678901234567890");
        // Performing arithmetic operations
        BigInteger anotherLargeNumber = new BigInteger("9876543210987654321098765432109876543210");
        BigInteger sum = largeNumber.add(anotherLargeNumber);
        BigInteger product = largeNumber.multiply(anotherLargeNumber);

        // Displaying results
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product.longValue());
    }

    private static void bigDecimal() {
        double result = ONE.subtract(BigDecimal.valueOf(20000).divide(BigDecimal.valueOf(100.0))).doubleValue();
        System.out.println("result = " + result);

        BigDecimal price = BigDecimal.valueOf(45.5);

        System.out.println("price.negate() = " + price.negate());

        System.out.println("price.negate().add(BigDecimal.valueOf(20)) = " + price.negate().add(BigDecimal.valueOf(20)));

        System.out.println("price = " + price);

        System.out.println("BigDecimal.valueOf(35000).compareTo(BigDecimal.valueOf(30000)) = " + BigDecimal.valueOf(35000).compareTo(BigDecimal.valueOf(30000)));
        System.out.println("BigDecimal.valueOf(35000).compareTo(BigDecimal.valueOf(35000)) = " + BigDecimal.valueOf(35000).compareTo(BigDecimal.valueOf(35000)));
        System.out.println("BigDecimal.valueOf(35000).compareTo(BigDecimal.valueOf(40000)) = " + BigDecimal.valueOf(35000).compareTo(BigDecimal.valueOf(40000)));
        BigDecimal.valueOf(45);
        BigDecimal quantity = new BigDecimal("3");
        BigDecimal total = price.multiply(quantity);

        total = total.setScale(2, RoundingMode.HALF_EVEN);

        System.out.println("Total: $" + total);
    }
}
