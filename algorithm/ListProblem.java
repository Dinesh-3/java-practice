package algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListProblem {
    public static void main(String[] args) {
        int[] numbers = { 4,3,2,7,8,2,3,1 };
//        numbers.length = 1; throw error length field is final
        shuffleArrayItemsInRandomOrder();
        char maxFrequency = findMaxFrequency("strawberry");
        System.out.println("maxFrequency = " + maxFrequency);

        int maxRepeatingDigit = findMaxRepeatingDigit(34323);
        System.out.println("maxRepeatingDigit = " + maxRepeatingDigit);

        List<Integer> duplicates = getDuplicates(numbers);
        System.out.println("duplicates = " + duplicates);

    }

    public static int findMaxRepeatingDigit(int n) {
        int arr[] = new int[10];
        int max = Integer.MIN_VALUE;
        while(n!=0) {
            int digit = n%10;
            arr[digit]++;
            if(arr[digit] > max)
                max = arr[digit];
            n=n/10;
        }
        System.out.println("Max find array = " + Arrays.toString(arr));
        return max;
    }

    private static void shuffleArrayItemsInRandomOrder() {
        /**
         * Operation O(N)
         */
        int[] numbers = {1,4,5,3,7,2};

        for (int i = 0; i < numbers.length; i++) {
            int randomIndex = (int) (Math.random()* (numbers.length - 1));
            swap(numbers, randomIndex, i);
        }

//        for (int i = numbers.length -1 ; i >= 0; i--) {
//            double random = Math.random() * i;
//            int alterIndex = (int) Math.floor(random);
////            System.out.println("random = " + random);
////            System.out.println("alterIndex = " + alterIndex);
//            swap(numbers, alterIndex, i);
//        }

        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    public static char findMaxFrequency(String input) {
        char[] chars = input.toCharArray();

        Map<Character, Integer> frequency = new HashMap<>();
        for(var item: chars)
            frequency.put(item, frequency.getOrDefault(item, 0) + 1);
        int max = 0;
        char letter = 'a';

        for(var item: frequency.entrySet())
            if(item.getValue() > max) {
                max = item.getValue();
                letter = item.getKey();
            };
//        return letter;

        List<Character> letters = input.chars().mapToObj(a -> (char) a).collect(Collectors.toList());
        System.out.println("letters = " + letters.get(0).charValue());

        Map<Character, Integer> collectedFrequency = letters.stream()
//                builder().add(chars)
//                .build()
                .collect(Collectors.toMap(a -> a, a -> 1, (a, b) -> a + b))
                ;
        System.out.println("collectedFrequency = " + collectedFrequency);

        // option 3
        // Java program to output the maximum occurring character in a string
         class GFG
        {
            static final int ASCII_SIZE = 256;
            char getMaxOccuringChar(String str)
            {
                // Create array to keep the count of individual
                // characters and initialize the array as 0
                int count[] = new int[ASCII_SIZE];

                // Construct character count array from the input
                // string.
                int len = str.length();
                for (int i=0; i<len; i++)
                    count[str.charAt(i)]++;

                int max = -1;  // Initialize max count
                char result = ' ';   // Initialize result

                // Traversing through the string and maintaining
                // the count of each character
                for (int i = 0; i < len; i++) {
                    if (max < count[str.charAt(i)]) {
                        max = count[str.charAt(i)];
                        result = str.charAt(i);
                    }
                }

                return result;
            }

            // Driver Method
            public void main(String[] args)
            {
                String str = "sample string";
                System.out.println("Max occurring character is " +
                        getMaxOccuringChar(str));
            }
        }
        return letter;
    }

    private static void swap(int[] numbers, int alterIndex, int index) {
        int temp = numbers[alterIndex];
        numbers[alterIndex] = numbers[index];
        numbers[index] = temp;
    }

    private static void firstMissingPositive() {
        /**
         *
         */
        int[] numbers = {4,5,1,3,7};
        int positive = 1;
//        for (int i = 0; i < numbers.length; i++) {
//            if(numbers[i] )
//        }
    }

    private static List<Integer> getDuplicates(int[] nums) {
        System.out.println("Before nums = " + Arrays.toString(nums));
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[nums[i] % (n + 1) - 1] += n + 1;
        }
        System.out.println("After nums = " + Arrays.toString(nums));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] / (n + 1) == 2)
                res.add(i + 1);
        }
        return res;

//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        List<Integer> list = new ArrayList<>();
//        for(int key: map.keySet()) {
//            if(map.get(key) > 1) list.add(key);
//        }
//        return list;

    }
}
