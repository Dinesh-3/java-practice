package datatype;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class BooleanType {
    public static void main(String[] args) {
        Boolean isEmployeeToEmployeeTransfer = false;

        // Incorrect check
        String result = (isEmployeeToEmployeeTransfer != null) ? Boolean.TRUE.toString() : null;

        System.out.println("result = " + result);

        Boolean eligible = null;

        if(eligible == FALSE)
            System.out.println("eligible = " + eligible);

        boolean isApplicable = eligible == TRUE ? true: false;


//        Boolean nullBoolean = null;
//
//        boolean isTrue = nullBoolean; // Throws -> Cannot invoke "java.lang.Boolean.booleanValue()" because "nullBoolean" is null
//
//        System.out.println("isTrue = " + isTrue);

    }
}
