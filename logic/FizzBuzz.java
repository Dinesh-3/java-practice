package logic;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println("--- FIZZ BUZZ GAME ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("ENTER NUMBER: ");
        int number = scanner.nextInt();

        String result = findFizzBuzz(number);

        System.out.println("RESULT: " + result);

    }

    private static String findFizzBuzz(int number) {
        if (number %5 ==0 && number %3 == 0) return "FIZZBUZZ";
        if (number %5 == 0) return "FIZZ";
        if (number %3 == 0) return "BUZZ";
        return String.valueOf(number);
    }

}
