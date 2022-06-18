package datatype;

public class NaNType {
    public static void main(String[] args) {
        double ZERO = 0;

        double NAN = ZERO / ZERO;
        System.out.println("ZERO / ZERO = " + NAN); // NaN
        System.out.println("INFINITY - INFINITY = " +(Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY)); // NaN
        System.out.println("INFINITY * ZERO = " + (Double.POSITIVE_INFINITY * ZERO)); // NaN
        System.out.println("ZERO * ZERO = " + ZERO * ZERO); // 0
        System.out.println("ZERO < ZERO = " + (ZERO < ZERO)); // false

        // Conditional check
        System.out.println("NaN == 1 = " + (NAN == 1)); // false
        System.out.println("NaN > 1 = " + (NAN > 1)); // false
        System.out.println("NaN < 1 = " + (NAN < 1)); // false
        System.out.println("NaN != 1 = " + (NAN != 1)); // true
        System.out.println("NaN == NaN = " + (NAN == NAN)); // false
        System.out.println("NaN > NaN = " + (NAN > NAN)); // false
        System.out.println("NaN < NaN = " + (NAN < NAN)); // false
        System.out.println("NaN != NaN = " + (NAN != NAN)); // true

        double threeDivideByZero = 3 / ZERO;
        System.out.println("3 / ZERO = " + threeDivideByZero); // Infinity

        System.out.println("2 + NaN = " +  (2 + Double.NaN));
        System.out.println("2 - NaN = " +  (2 - Double.NaN));
        System.out.println("2 * NaN = " +  (2 * Double.NaN));
        System.out.println("2 / NaN = " +  (2 / Double.NaN));
    }
}
