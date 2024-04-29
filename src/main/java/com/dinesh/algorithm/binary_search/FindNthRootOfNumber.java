package com.dinesh.algorithm.binary_search;

/**
 *
 * https://www.youtube.com/watch?v=rjEJeYCasHs
 * https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
 *
 *
 */
public class FindNthRootOfNumber {
    public static void main(String[] args) {
        int sq = 8;
        int number = 256;

        FindNthRootOfNumber root = new FindNthRootOfNumber();

        int result = root.nthRoot(sq, number);
        System.out.println("result = " + result);

    }

    private int nthRoot(int sq, int number) {

        int left = 0;
        int right = number;

        while ( left <= right ) {
            int mid = left + (right - left) / 2;
            int mul = nMultiply(mid, sq);
            if(mul == number)
                return mid;

            if(mul < number)
                left = mid + 1;
            else
                right = mid - 1;

        }

        return right;
    }

    private int nMultiply(int num, int sq) {
//        for(int i = 1; i < sq; i++)
//            mul *= mul;
        int power = sq;

        int base = num;

        int ans = 1;
        while(power > 0 ) {
            if(power % 2 == 1) {
                ans = num * base;
                power = power - 1;
            } else {
                base = base * base;
                power = power / 2;
            }
        }

        return ans;
    }
}

