package com.dinesh.algorithm.binary_search;

public class FindSquareRootOfNumber {
    public static void main(String[] args) {
        FindSquareRootOfNumber root = new FindSquareRootOfNumber();

        int sqrt = root.sqrt(64);
        System.out.println("sqrt = " + sqrt);
    }

    private int sqrt(int number) {
        int left = 1;
        int right = number;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int square = mid * mid;

            if(square <= number)
                left = mid + 1;
            else
                right = mid - 1;
        }


        return right;
    }

}
