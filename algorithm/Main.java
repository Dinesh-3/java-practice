package algorithm;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
//        Output: Sum found between indexes 2 and 4
//        Sum of elements between indices
//        2 and 4 is 20 + 3 + 10 = 33
        int[] array = { 1, 4, 20, 3, 10, 5 };
        int target = 13;
        int right = 0;
        int left = 0;

        int sum = 0;

        int index = 0;
        while (index < array.length && left < array.length) {
            int add = sum;
            if(sum < target) {
                 add = sum + array[index];
            }
            if(add == target) {
                System.out.println("left = " + left + " right = "+ index);
                break;
            }else if (add > target){
                sum = add - array[left++];
            }else {
                sum = add;
                index++;
            }
//            if(add < target) {
//
//            }else {
//
//            }
        }
//        for (int i = 0; i < array.length; i++) {
//            right = i;
//            int add = sum + array[i];
//            if(add == target) {
//                System.out.println("left = " + left + " right = "+ right);
//                break;
//            }
//            if(add < target) {
//                sum = add;
//            }else {
//                sum = add - array[left++];
//            }
//        }
        System.out.println("SUM = " + sum + " left = " + left + " right = "+ index);

        Factorial factorial = new Factorial();
        int fact = factorial.get(4);
        System.out.println("fact = " + fact);


        FibonacciSeries series = new FibonacciSeries();
        int[] ints = series.get(5);
        System.out.println("ints = " + Arrays.toString(ints));

        stringOperations();
    }


    public static void stringOperations(){
        String name = "Dinesh";

        findNumberOfVowels(name);
        reverseString(name);
    }

    private static void reverseString(String name) {
        var builder = new StringBuilder();
        for (int i = name.length() - 1; i >= 0; i--) {
            builder.append(name.charAt(i));
        }
        System.out.println("builder.toString() = " + builder.toString());
    }

    private static void findNumberOfVowels(String name) {
//        final List<Character>  VOWELS = new ArrayList<>(List.of('A', 'E', 'I', 'O', 'U','a', 'e', 'i', 'o', 'u'));
        final Set<Character>  VOWELS = new HashSet<>(Set.of('A', 'E', 'I', 'O', 'U'));
        int vowelCount = 0;

        for (var letter: name.toUpperCase().toCharArray()){
            boolean contains = VOWELS.contains(letter);
            if (contains) vowelCount++;
        }
        System.out.println("vowelCount = " + vowelCount);
    }

}
