package operators;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class BitPuzzle {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2021, 10, 10);
        DayOfWeek week = date.getDayOfWeek();
        System.out.println("week = " + week);
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
        String s1 = String.valueOf(10);
        System.out.println("s1 = " + s1);
        int mask = 0x000F;
        int value = 0x2222;
        System.out.println(value & mask);
    }
}
public class BitwiseOperators {

    public static void main(String[] args) {
        shift();
        bitwise();
    }

    public static void bitwise() {
        System.out.println(" --- BITWISE OPERATORS --- ");
        // Initial values
        int a = 5;
        int b = 7;

        System.out.printf("a = %s, b = %s\n", a, b);

        /**
         * bitwise and
         * 8421
         * 0101
         * 0111
         * -----
         * 0101 = 5
         */
        System.out.println("a&b = " + (a & b));

        /**
         * bitwise or
         * 0101
         * 0111
         * ----
         * 0111 = 7
         */
        System.out.println("a|b = " + (a | b));

        /**
         * bitwise xor
         * 0101
         * 0111
         * ----
         * 0010 = 2
         */
        System.out.println("a^b = " + (a ^ b));

        /**
         * bitwise not
         * ~0101 = 5
         * -----
         * 1010 = -6
         * will give 2's complement of 1010 = -6
         */
        System.out.println("~a = " + ~a);

        /**
         * can also be combined with
         * assignment operator to provide shorthand
         * assignment
         * a=a&b
         */
        a &= b;
        System.out.println("a= " + a);
    }

    // shift operators
    public static void shift()
    {
        System.out.println(" --- SHIFT OPERATORS --- ");
        int a = 5;
        int b = -10;

        System.out.printf("a = %s, b = %s\n",a,b);

        // left shift operator
        // 0000 0101<<2 =0001 0100(20)
        // similar to 5*(2^2)
        System.out.println("a<<2 = " + (a << 2));

        // right shift operator
        // 0000 0101 >> 2 =0000 0001(1)
        // similar to 5/(2^2)
        System.out.println("b>>2 = " + (b >> 2));

        // unsigned right shift operator
        System.out.println("b>>>2 = " + (b >>> 2));
    }

}
