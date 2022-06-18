package problems;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = 5;
        int factorial = factorialOf(number);
        System.out.println("factorial = " + factorial);
        int reverse = reverseNumber(123);
        System.out.println("reverse = " + reverse);
        int countDigit = countDigit(34540324, 4);
        System.out.println("countDigit = " + countDigit);
    }

    private static int factorialOf(int number) {
//        int fact = 1;
//        for (int i = 1; i <= number; i++) {
//            fact *= i;
//        }
//        System.out.println(fact);
        int index = 1 ;
        int factorial = 1;
        while (index <= number) {
            factorial *= index;
            index++;
        }
        return factorial;
    }

    public static int reverseNumber(int x) {

        int reversedNumber = 0;
        int digit = x;
        int finalDigit = digit;

        int finalReversedNumber = reversedNumber;
        class Name{
            public int name = finalDigit; // class assigned variable should not updated or assigned new value

            public int getName() {
                return finalReversedNumber;
            }
        }
        new Name();
        while(digit != 0) {
            int mod = digit%10;
            reversedNumber = reversedNumber * 10 + mod;
            digit = digit / 10;

            System.out.println("digit = " + digit);
        }
        return reversedNumber;
    }

    public static int sumOfDigit(int number){
        int sum = 0;
        while (number !=0 ) {
            int mod = number % 10;
            sum += mod;
            number = number / 10;
        }
        System.out.println("sum = " + sum);
        return sum;
    }

    public static int countDigit(int number, int target){
        int count = 0;
        while (number !=0 ) {
            int mod = number % 10;
            if(mod == target) count++;
            number = number / 10;
        }
        System.out.println("count = " + count);
        return count;
    }
}
