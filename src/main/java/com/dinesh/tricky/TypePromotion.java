package com.dinesh.tricky;

class MathOperation {
    // byte > short > int > long > float > double
//    public int add(int a, int b) {
//        System.out.println("long add(int a, int b)");
//        return a + b;
//    }
    public int add(int a, int b, int c) {
        System.out.println("long add(int a, long b, int c)");
        return a + b + c;
    }


    public long add(int a, long b) {
        System.out.println("long add(int a, long b)");
        return a + b;
    }

    public long add(long a, int b) { // throws ambiguity error
        System.out.println("long add(int a, long b)");
        return a + b;
    }


//    public int add(int a, int b) {
//        return a + b;
//    }
//    public int add(int a, int b) {
//        return a + b;
//    }
}

public class TypePromotion {
    public static void main(String[] args) {
        MathOperation math = new MathOperation();
//        int add = math.add(1, 1); // Throws error
        /**
         * Ambiguous method call. Both
         * add (int, long) in operators.MathOperation  and
         * add (long, int) in operators.MathOperation  match
         *
         * Notes:
         *  Smaller values are adjusted in big types ex: int to long
         *
         *  What is Automatic Type Promotion?
         * The name Type Promotion specifies that a small size datatype can be promoted to a large size datatype. i.e.,
         * an Integer data type can be promoted to long, float, double, etc.
         * This Automatic Type Promotion is done when any method which accepts a higher size data type argument is called with the smaller data type.
         */
        long addLong = math.add(1, (long) 1);

        int number = 256;
        int number1 = 128;

        byte byteNum = (byte) number;
        byte byteNum1 = (byte) number1;
        System.out.println("byteNum = " + byteNum);
        System.out.println("byteNum1 = " + byteNum1);

    }
}
