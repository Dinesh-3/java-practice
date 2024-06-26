package com.dinesh.algorithm.binary_search;

public class FindSquareRootOfNumber {
    public static void main(String[] args) {
        FindSquareRootOfNumber root = new FindSquareRootOfNumber();

        int sqrt = root.sqrt(64);
        System.out.println("sqrt = " + sqrt);

        long floorSqrt = root.floorSqrt(64);
        System.out.println("floorSqrt = " + floorSqrt);
    }

    private int sqrt(int number) {
        int left = 1;
        int right = number;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int square = mid * mid;

            if(square <= number)
                left = mid + 1;
            else
                right = mid - 1;
        }


        return right;
    }

    long floorSqrt(long x)
    {
        long low = 0;
        long high = x;

        long sqrt = -1;
        while(low <= high) {
            long mid = ( low + high ) / 2;

            if(mid * mid <= x) {
                sqrt = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return sqrt;

    }

}
