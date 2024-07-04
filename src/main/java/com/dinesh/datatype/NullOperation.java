package datatype;

public class NullOperation {
    public static void main(String[] args) {

        Boolean isValid = null;

        passingNullForPrimitiveBoolean(isValid); // Exception in thread "main" java.lang.NullPointerException at datatype.NullOperation.main(NullOperation.java:8)

    }

    private static void passingNullForPrimitiveBoolean(boolean isValid){
        System.out.println("isValid = " + isValid);
    }

}

