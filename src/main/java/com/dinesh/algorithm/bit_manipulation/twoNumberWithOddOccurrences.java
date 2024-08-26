package com.dinesh.algorithm.bit_manipulation;

/**
 *
 * Find the two numbers appearing odd number of times
 * https://www.youtube.com/watch?v=UA5JnV1J2sI
 *
 */
public class twoNumberWithOddOccurrences {
    public int[] twoOddNum(int Arr[], int N)
    {
        int xor = 0;

        for(int num : Arr)
            xor = xor ^ num;

        int rightSetBit = (xor & xor - 1) ^ xor; //

        int b1 = 0;
        int b2  = 0;

        for(int num: Arr) {
            if((num & rightSetBit) != 0)
                b1 = b1 ^ num;
            else
                b2 = b2 ^ num;
        }


        return b1 > b2 ? new int[]{ b1, b2 } : new int[]{ b2, b1 };

    }

}
