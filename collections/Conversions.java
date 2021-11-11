package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Conversions {
    public static void main(String[] args) {
        forBooleans();
        int[] primitiveIntegers = {1,3,5,2,4};
        Integer[] boxedIntegers = {1,3,5,2,4}; // new Integer[]{...} optional

        List<int[]> asListint = Arrays.asList(primitiveIntegers); // wrong
        List<int[]> listOf = List.of(primitiveIntegers); // wrong
        String[] strings = {"Apple", "Ball", "Cat"};

        List<String> users = new ArrayList<>();
        Collections.addAll(users, strings); // if it is integer we can only put boxed Integer[]
        System.out.println("users = " + users);


        System.out.println("asListint = " + asListint);
        System.out.println("listOf = "  + listOf);

        List<Integer> asListInteger = Arrays.asList(boxedIntegers);
        System.out.println("asListInteger = " + asListInteger);

        List<Integer> collect = Arrays.stream(primitiveIntegers).boxed().collect(Collectors.toList());
        System.out.println("collected list = " + collect);

        ArrayList<Integer> arrayList = Arrays.stream(boxedIntegers)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("arrayList = " + arrayList);

        List<String> stringList = List.of(strings);
        List<String> stringAsList = Arrays.asList(strings);
    }

    public static void forBooleans() {
        boolean[] primitiveBooleans = {true, false, false, true};
        Boolean[] boxedBooleans = {true, false, false, true};

        List<boolean[]> booleanAsList = Arrays.asList(primitiveBooleans); // wrong
        List<Boolean> boxedBooleanAsList = Arrays.asList(boxedBooleans); // write
    }
}
