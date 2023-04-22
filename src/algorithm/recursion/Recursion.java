package algorithm.recursion;

public class Recursion {
    public static void main(String[] args) {
        String fullName = "Dinesh Iyyandurai";

        String reverseString = reverseString(fullName);
//        System.out.println("reverseString(\"\") = " + reverseString(""));
//        System.out.println("reverseString(\"d\") = " + reverseString("d"));

        System.out.println("reverseString = " + reverseString);

        String racecar = "racecar";

        System.out.println("isPalindrome(racecar) = " + isPalindrome(racecar));
        System.out.println("isPalindrome(\"sf\") = " + isPalindrome("sf"));

        System.out.println("integerToBinary(8) = " + integerToBinary(8, ""));

        System.out.println("sumOfNaturalNumbers(3) = " + sumOfNaturalNumbers(3));

    }

    public static String reverseString(String content){
        int lastIndex = content.length() -1;

        if(lastIndex < 0)
            return "";

//        return content.substring(lastIndex) + reverseString(content.substring(0, lastIndex));
        return reverseString(content.substring(1)) + content.charAt(0);
    }

    public static boolean isPalindrome(String content){
        if(content.length() < 2)
            return true;
        if(content.charAt(0) == content.charAt(content.length() - 1))
            return isPalindrome(content.substring(1, content.length() - 1));
        return false;
    }

    public static String integerToBinary(int number, String binary){
        if(number <= 0)
            return binary;
        binary = number % 2 + binary;
        return integerToBinary(number / 2, binary);
    }

//    public static int sumOfNaturalNumbers(int number, int sum) {
//        if(number == 0) return sum;
//        return sumOfNaturalNumbers(number - 1, sum + number);
//    }
    public static int sumOfNaturalNumbers(int number) {
        if(number <= 1) return 0;
        return number + sumOfNaturalNumbers(number - 1);
    }

    public static int fibonacciNumber(int number) {
        if(number <= 1)
            return number;
        return fibonacciNumber(number - 1) + fibonacciNumber(number - 2);
    }

}
