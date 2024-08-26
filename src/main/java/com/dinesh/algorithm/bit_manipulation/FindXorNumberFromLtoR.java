package com.dinesh.algorithm.bit_manipulation;


/**
 *
 * Pattern
 *
 * 1^0 -> 1
 * 1^2 -> 3
 * 1^2^3 -> 0
 * 1^2^3^4 -> 4
 *
 * 1^2^3^4^5 -> 1
 * 1^2^3^4^5^6 -> 7
 * 1^2^3^4^5^6^7 -> 0
 * 1^2^3^4^5^6^8 -> 8
 *
 * if l is 3
 * and r is 5
 * formula f(l-1)^f(r)
 */

public class FindXorNumberFromLtoR {
    public static int findXOR(int l, int r) {
        return getXor1toN(l-1) ^ getXor1toN(r);
    }

    private static int getXor1toN(int n) {
        if(n % 4 == 1)
            return 1;
        if(n%4 == 2)
            return n + 1;
        if(n%4 == 3)
            return 0;
        // if(n%4 == 0)
        return n;
    }

}
