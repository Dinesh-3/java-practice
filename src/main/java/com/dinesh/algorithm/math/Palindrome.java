package com.dinesh.algorithm.math;

public class Palindrome {
    public static void main(String[] args) {
        int x = 0;

        Palindrome palindrome = new Palindrome();
        boolean isPalindrome = palindrome.isPalindrome(x);
        System.out.println("isPalindrome = " + isPalindrome);
    }
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);

        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }

        return true;

    }
}
