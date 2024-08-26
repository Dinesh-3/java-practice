package com.dinesh.algorithm.binary_search;

public class CubeOfANumber {
    public static void main(String[] args) {

        int number = 7; // 1.912353515625

        double low = 0;
        double high = number;

        while ((high - low) > 0.001) {
            double mid = (low + high) / 2;
            double cube = mid * mid * mid;
            System.out.println(cube);
            if(cube > number)
                high = mid;
            else
                low = mid;
        }

        System.out.println("low = " + low);

    }
}
