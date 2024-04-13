package com.dinesh.algorithm.array;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/#arrays
 */
public class ArrayProblems {
    public static void main(String[] args) {

        int[] numbers = {1, 3, 4, 5};
        System.out.println(Math.pow(4,2));
        List<Character> brackets
                = Arrays.asList('(', '<', '[', '{');
        brackets.subList(0,0);
//        subArrayOfGivenSum(numbers, 7);
//        missingNumberInArray();
//        mergeWithoutExtraSpace();
        rearrangeArrayAlternatively();
//        numberOfPairs();
//        countInversions();
        equilibriumPoint();
//        reverseArrayInGroups();
//        kthSmallestElement();
//        trappingRainWater();
//        turbulantSubArray();
//        findMinAndMax();

//        smallerPositiveMissingNumber();
        firstRepeatingElement();
//        int[] arrays = { 1, 5, 3, 2 };
//        for (int i = 0; i < arrays.length; i++) {
//            int sum = arrays[i];
//            for (int j = 0; j < arrays.length; j++) {
//                if(sum - arrays[j] > 0 ) {
//                    sum -= arrays[j];
//                }
//                if(sum == 0){
//                    System.out.println("sum = " + sum);
//                }
//            }
//        }
    }

    private static void smallerPositiveMissingNumber() {

        /**
         * Smallest Positive missing number
         * You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
         * Input: N = 5 arr[] = {1,2,3,4,5} Output: 6
         * Explanation: Smallest positive missing number is 6.
         *
         * Input:  N = 5 arr[] = {0,-10,1,3,-20} Output: 2
         * Explanation: Smallest positive missing number is 2.
         */

        int[] numbers = {0,-10,1, 3,-20};

        int smallNumber = 1;

        Arrays.sort(numbers);

        for (int number : numbers) {
            if (number == smallNumber)
                smallNumber++;
            else if (smallNumber < number)
                break;
        }

        System.out.println("smallNumber = " + smallNumber);

    }

    private static void subArrayOfGivenSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = i; j < numbers.length; j++) {
                sum += numbers[j];
                if(sum == target) {
                    System.out.println("sum = " + sum);
                    System.out.println("i , j = " +i +","+j);
                    break;
                }
            }
        }

        // O(N) approach
        int left = 0;
        int right = 0;
        int currentSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(currentSum + numbers[i] == target ){
                currentSum += numbers[i];
                System.out.println(currentSum);
            }else if (currentSum + numbers[i] < target){
                right++;
                currentSum += numbers[right];
            }else {
                currentSum -= numbers[left++];
            }
        }
        System.out.println("currentSum = " + currentSum);
        System.out.println(left + ", " + right);
    }

    public static void missingNumberInArray() {
        int[] numbers = {6,2,8,3,4,7,10,5};

        for (int i = 1; i <= numbers.length ; i++) {
            boolean isExist = false;
            for (int number : numbers) {
                if (number == i) {
                    isExist = true;
                    break;
                }
            }
            if(!isExist) System.out.println(i);
        }

        // Approach TWO using Set O(N) complexity
        Set<Integer> set = new HashSet<>();
        for(int number: numbers) set.add(number);

        for (int i = 1; i <= Collections.max(set) ; i++) {
            if(!set.contains(i)) System.out.println(i);
        }
    }

    public static void mergeWithoutExtraSpace() {
        int[] first = {1, 3, 5, 7};
        int[] second = {0, 2, 6, 8, 9};

        for (int i = 0; i < first.length; i++) {
            if(first[i] > second[i]) {
                int temp = first[i];
                first[i] = second[i];
                second[i] = temp;
            }
        }
        System.out.println("first = " + Arrays.toString(first));
        System.out.println("second = " + Arrays.toString(second));
    }

    public static void rearrangeArrayAlternatively() {
        int[] nums = {1,2,3,4,5,6};
        int length = nums.length;;

        int[] alter = new int[length];
        int left = 0;
        int right = length - 1;
        boolean alterFlag = true;
        for (int i = 0; i < length; i++) {
            if(alterFlag) alter[i] = nums[right--];
            else alter[i] = nums[left++];
            alterFlag = !alterFlag;
        }
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("alter = " + Arrays.toString(alter));
    }

    public static void numberOfPairs() {
        /**
         *
         */

        int[] x = {2, 3, 4, 5};
        int[] y = {1, 2, 3};
        int count = 0;

        for (int k : y) {
            for (int i : x) {
                if (Math.pow(i,k) > (Math.pow(k,i))) {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);

    }

    public static void countInversions(){
        int[] numbers = {0, 2 ,1 ,2, 0};

//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = 0; j < numbers.length ; j++) {
//                if(numbers[i] < numbers[j]) swap(i,j,numbers);
//            }
//            System.out.println("numbers = " + Arrays.toString(numbers));
//        }
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < numbers.length - i; j++) {
                if(numbers[j-1] > numbers[j]) {
                    swap(j, j-1, numbers);
                    isSorted = false;
                }
            }
            if(isSorted) break;
            count++;
        }
        System.out.println("count = " + count);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    public static void equilibriumPoint() {
        int[] numbers = {1,3,5,2,2};

        int sum = Arrays.stream(numbers).sum();

        int equiliSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            equiliSum += numbers[i];
            if(equiliSum == sum){
                System.out.println("Equilibrium Point = " + i);
                break;
            }
            sum -= numbers[i];
        }
    }

    public static void reverseArrayInGroups(){
        int[] numbers = {1,2,3,4,5, 6, 7};
        int n = numbers.length;;
        int group = 3;
        for (int i = 0; i < n ; i+= group) {
            System.out.println("i = " + i);
            int left = i;
            int right = Math.min(i + group - 1, n - 1);
            while (left < right) {
                swap(left, right, numbers);
                left++;
                right--;
            }
        }
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    public static void kthSmallestElement() {
        int[] numbers = { 7, 10, 4, 20, 15 };
        int k = 3;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            minHeap.add(number);
        }

        for (int i = 0; i < k; i++) {
            minHeap.remove();
        }

        System.out.println("minHeap = " + minHeap.peek());

    }

    public static void trappingRainWater(){
        int[] tank = {2,0,6,0,10,9};

        int left=0;
        int right=tank.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(left<=right){
            leftmax=Math.max(leftmax,tank[left]);
            rightmax=Math.max(rightmax,tank[right]);
            if(leftmax<rightmax){
                max+=(leftmax-tank[left]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                left++;
            }
            else{
                max+=(rightmax-tank[right]);
                right--;
            }
        }
        System.out.println("max = " + max);

//        int totalCapacity = tank[0] * (tank.length - 2);
//
//        for (int i = 1; i < tank.length - 1; i++) {
//            if(tank[i] > tank[0]) tank[i] = tank[0];
//            totalCapacity -= tank[i];
//        }
//        System.out.println("totalCapacity = " + totalCapacity);
    }

    public static void turbulantSubArray() {
        int[] numbers = {9,4,2,10,7,8,8,1,9};
        int inc = 1, dec = 1, res = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else if (numbers[i] < numbers[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            res = Math.max(res, Math.max(inc, dec));
        }
        System.out.println("res = " + res);
//        boolean[] table = new boolean[numbers.length];
//
//        if(numbers.length == 1) {
//            System.out.println("max = " + 1);
//            return;
//        }

//        for (int i = 0; i < numbers.length - 1; i++) {
//            boolean isValid;
//            if(i%2 == 0 ) {
//                isValid = numbers[i] < numbers[i + 1];
//            }else {
//                isValid = numbers[i] > numbers[i + 1];
//            }
////            table[i] = table[i] ? table[i] : isValid;
//            table[i + 1] = isValid;
//        }

//        int max = 0;
//        int count = 0;
//        for (boolean b : table) {
//            if (b) count++;
//            else {
//                max = Math.max(count, max);
//                count = 0;
//            }
//        }
//        max = Math.max(count, max);
//        System.out.println("max = " + max);

//        System.out.println("table = " + Arrays.toString(table));
    }

    public static void findMinAndMax(){
        int numbers[] = {3, 2, 1, 56, 10000, 167};

        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            if (number < min) min = number;
            if (number > max) max = number;
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    private static void firstRepeatingElement(){

        int[] numbers = {1, 5, 3, 4, 3, 5, 6};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            map.put(numbers[i], map.getOrDefault(number, 0) + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) > 1){
                System.out.println("result = " + numbers[i]);
                break;
            }
        }

        /**

        Map<Integer, Integer[]> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            Integer[] value;
            if (map.containsKey(number)){
                value = map.get(number);
                value[1] = value[1] + 1;
            }else{
                value = new Integer[]{i, 1};
            }
            map.put(number, value);
        }


        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            System.out.println(String.format("Number %d, Index %d, Count %d ", entry.getKey(), entry.getValue()[0], entry.getValue()[1]));
        }

        Map.Entry<Integer, Integer[]> result = null;

        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()){
            if (result == null && entry.getValue()[1] > 1) {
                result = entry;
            } else if (entry.getValue()[1] > 1 && entry.getValue()[0] < result.getValue()[0])
                result = entry;
        }

        System.out.println("result = " + result);
         **/

    }
    static int longestPalSubstr(String str)
    {
        // get length of input String
        int n = str.length();

        // All subStrings of length 1
        // are palindromes
        int maxLength = 1, start = 0;

        // Nested loop to mark start and end index
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k)) {
                        flag = 0;
                        break;
                    }

                // Palindrome
                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        System.out.print("Longest palindrome subString is: ");
        System.out.println(maxLength);
        System.out.println(start);

        // return length of LPS
        return maxLength;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
