package com.dinesh.algorithm.binary_search;

/**
 *  2 ^ 8 -> 4 ^ 4 -> 16 ^ 2 -> 256 ^ 1
 *  Square the base and divide the power by half
 *  In above 2 * 2 will be -> 4 and half of 8 will be 4 therefore -> 4 ^ 4
 *  Continue these steps until the power leads to zero or 1
 */
public class BinaryExponentialPowerOfN {
    public static void main(String[] args) {
        BinaryExponentialPowerOfN powerOfN = new BinaryExponentialPowerOfN();
        int nPower = powerOfN.nMultiply(2, 8);
        System.out.println("nMultiply = " + nPower);
    }

    private int nMultiply(int num, int sq) {
//        for(int i = 1; i < sq; i++)
//            mul *= mul;
        int power = sq;

        int base = num;

        while(power > 1 ) {
            base = base * base;
            power = power / 2;
        }

        return base;
    }
}
