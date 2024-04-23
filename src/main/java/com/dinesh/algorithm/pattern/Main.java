package com.dinesh.algorithm.pattern;

public class Main {
    public static void main(String[] args) {
        int n = 5;
//        nForest(n);
//        nBy2Forest(n);
//        triangleNumber(n);
//        increaseDecreaseStar(n);
//        oneToN(n);
//        centerTriangle(n);
//        topToBottomTriangle(n);
//        diamond(n);
//        nStartRotatedTriangle(n);
//        oneZeroOne(n);
//        vBucket(n);
        increaseNumber(n);

    }

    /**
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     * 11 12 13 14 15
     */
    private static void increaseNumber(int n) {
        int count = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }

    /**
         1        1
         12      12
         123    123
         1234  1234
         1234512345
     */
    private static void vBucket(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 0; j <= ((n * 2 - 1) - i * 2); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void oneZeroOne(int n) {
        for (int i = 0; i <= n; i++) {
            boolean flag = (i % 2 == 0 ? false : true);
            for (int j = 0; j < i; j++)
            {
                System.out.print(flag ? "1" : "0");
                flag = !flag;
            }
            System.out.println();
        }
    }

    /**
         *
         **
         ***
         ****
         *****
         ****
         ***
         **
         *
     */

    private static void nStartRotatedTriangle(int n) {
        nBy2Forest(n);
        increaseDecreaseStar(n);
    }

    /**
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     * *********
     *  *******
     *   *****
     *    ***
     *     *
     */
    private static void diamond(int n) {
        centerTriangle(n);
        topToBottomTriangle(n);
    }

    /**
     * *********
     *  *******
     *   *****
     *    ***
     *     *
     */
    private static void topToBottomTriangle(int n) {
        n = n * ( n /2 );
        for (int i = n; i >= 1; i--) {
            if(i % 2 == 0 )
                continue;
            for (int j = 0; j < ((n - i) / 2); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < ((n - i) / 2); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    /**
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     */
    private static void centerTriangle(int n) {
        n = n * ( n /2 );
        for (int i = 1; i <= n ; i++) {
            if(i % 2 == 0 )
                continue;
            for (int j = 0; j < ((n - i) / 2); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < ((n - i) / 2); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    /**
     * 1234
     * 123
     * 12
     * 1
     */
    private static void oneToN(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * *****
     * ****
     * ***
     * **
     * *
     */
    private static void increaseDecreaseStar(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    /**
     * 11
     * 222
     * 3333
     * 44444
     * 555555
     */
    private static void triangleNumber(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(i);
            System.out.println();
        }
    }

    /**
     * * * *
     * * * *
     * * * *
     */
    private static void nForest(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * *
     * **
     * ***
     * ****
     */
    private static void nBy2Forest(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

}
