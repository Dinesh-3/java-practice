package com.dinesh.maths;

/**
 *
 * 1 byte -> 8 bit
 *
 * byte - 1 byte
 * short - 2 byte
 * int - 4 byte
 * long - 8 byte
 *
 * float - 4 byte
 * double - 8 byte
 * boolean - 1 bit
 * char - 2 bytes
 *
 */
public class DecimalPractice {
    public static void main(String[] args) {
        double input1 = 10.7524853;
        double input2 = 10.7529484;

        boolean equals = isPrecise(input1, input2, 3);
        System.out.println("equals = " + equals);
    }

    private static boolean isPrecise(double input1, double input2, int precise) {
        if(precise < 1)
            return input1 == input2;

        long count = 1;
        for(int i = 0; i < precise; i++)
            count = count * 10;

        long one =  (long) (input1 * count);
        long two = (long) (input2 * count);

        return one == two;
    }
}
