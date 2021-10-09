package tricky;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassPractise {
    public static void main(String[] args) {
        Method[] methods = Object.class.getMethods();
        for(var method:methods){
            System.out.print(
                    "Method Name: "+method.getName()
                            + " "
//                            + "Params count: " +
//                            method.getParameterCount()
            );
//            method.canAccess(new Object());\
            System.out.print(" Params: " + Arrays.toString(method.getParameters()));
            System.out.println();
        }
    }
}
