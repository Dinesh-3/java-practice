package problems;

public class Main {

    public static void main(String[] args) {
        int reverse = reverseNumber(123);
        System.out.println("reverse = " + reverse);
    }
    public static int reverseNumber(int x) {
        int reversedNumber = 0;
        int digit = x;
        while(digit != 0) {
            int mod = digit%10;
            reversedNumber = reversedNumber * 10 + mod;
            digit = digit / 10;
            System.out.println("digit = " + digit);
        }
        return reversedNumber;
    }
}
