package algorithm;

import java.util.*;

/**
 *
 * Top 5 Math Skills To be mastered
 * 1. Combinations
 * 2. Logarithm
 * 3. Factorial
 * 4. Exponential
 * 5. Modulus
 */

public class Main {
    public static void main(String[] args) {

        double atm = withdrawFromATM();
        System.out.println("atm = " + atm);

        practise();
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
        long fact = factorial.get(4);
        System.out.println("fact = " + fact);


        FibonacciSeries series = new FibonacciSeries();
        int[] ints = series.get(5);
        System.out.println("ints = " + Arrays.toString(ints));

        stringOperations();
    }

    private static double withdrawFromATM() {
        /**
         * https://www.codechef.com/problems/HS08TEST
         */
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] inputs = line.split(" ");
        double withdraw = Double.parseDouble(inputs[0]);
        double total = Double.parseDouble(inputs[1]);
        if (withdraw + 0.5 > total) return total;
        if(withdraw % 5 == 0) {
            return total - withdraw - 0.50;
        }
        return total;
    }

    private static void practise() {
        String ransomNote = "aba";
        String magazine = "baa";

        Map<Character, Integer> ransomCount = new HashMap<>();
        Map<Character, Integer> magazineCount = new HashMap<>();

        boolean isValid = true;

        for(int i = 0; i < ransomNote.length(); i++){
            char letter = ransomNote.charAt(i);
            ransomCount.put(letter, ransomCount.getOrDefault(letter, 0) + 1);
//            if(ransomNote.charAt(i) != magazine.charAt(i)) isValid = false;
        }

        for(int i = 0; i < magazine.length(); i++){
            char letter = magazine.charAt(i);
            magazineCount.put(letter, magazineCount.getOrDefault(letter, 0) + 1);
        }
        System.out.println("ransomCount = " + ransomCount);
        System.out.println("magazineCount = " + magazineCount);
        for(char letter: ransomCount.keySet()){
            if(ransomCount.get(letter) > magazineCount.getOrDefault(letter, 0)) {
                isValid = false;
            };
        }

        System.out.println(isValid);

//        int[] words = new int[26]; // Approach 2
//
//        for (int i=0; i<magazine.length(); i++) {
//            words[magazine.charAt(i) - 'a']++;
//        }
//        for (int i=0; i<ransomNote.length(); i++) {
//            if (--words[ransomNote.charAt(i) - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;
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
