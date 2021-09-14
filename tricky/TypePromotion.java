package tricky;

class MathOperation {
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
         * add (int, long) in MathOperation  and
         * add (long, int) in MathOperation  match
         *
         * Notes:
         *  Smaller values are adjusted in big types ex: int to long
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
