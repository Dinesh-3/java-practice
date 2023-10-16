package com.dinesh.algorithm.dynamic_programming;

import java.util.*;
import java.util.stream.Collectors;

/**
 * BruteForce:
 * Normally -> O(2^n) -> here n is the height of the recursion tree
 * array              target
 * Complexity -> O(branchingFactor * heightFactor)
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        String name = "DInesh";

        System.out.println("name.substring(1) = " + name.substring(1));
        System.out.println("name.substring(1) = " + name.substring(1,3));
        String palindromeSubstring = longestPalindromeSubstring("sdfmalayalamdne");
        System.out.println("palindromeSubstring = " + palindromeSubstring);
//        boolean[][] grid = {
//                {true, true, true, true},
//                {true, true, true, true},
//                {true, true, true, true},
//                {true, true, true, true},
//        };
        boolean[][] grid = {
                { true, true, true },
                { true, false,  true },
                { true, true,  true }
        };
        int possiblePaths = countAllPossiblePath(grid, 0, 0);
        System.out.println("possiblePaths = " + possiblePaths);

        List<String> strings = letterCombinations("23");
        System.out.println("strings = " + strings);

        // Count Possible combination of coins
        int[] coins = {3, 4, 5, 7};
        int possibleCoin = countPossibleCoin(coins, coins.length, 5);
        System.out.println("possibleCoin = " + possibleCoin);
        int possibleCoinOptimized = countPossibleCoinOptimized(coins, coins.length, 7);
        System.out.println("possibleCoinOptimized = " + possibleCoinOptimized);

        int traversal = gridTraversal(4, 4, new HashMap<>());
        System.out.println("traversal = " + traversal);

        boolean canSome = canSome(111, coins,  new HashMap<>());
        System.out.println("canSome = " + canSome);


        List<Integer> howSome = howSome(111, coins, new HashMap<>());
//        howSome.stream().reduce(0, (a, b) -> a+b);
//        howSome.size();
        System.out.println("howSome = " + howSome);
        List<Integer> bestSome = bestSome(9, coins, new HashMap<>());
        bestSome.size();
        System.out.println("bestSome = " + bestSome);

        List<Integer> converted = Arrays.stream(coins).boxed().collect(Collectors.toList());
        List<List<Integer>> allSomeCount = allSomeCount(7, converted, new ArrayList<>(), new ArrayList<>());
        System.out.println("allSomeCount = " + allSomeCount);


        boolean construct = canConstruct("cdabc", Arrays.asList("ab", "abc", "cd", "def", "abcd"));
        System.out.println("construct = " + construct);

        int countConstruct = countConstruct("abcd", Arrays.asList("ab", "abc", "cd", "def", "abcd"));
        System.out.println("countConstruct = " + countConstruct);

        String palindrome = "forsfgksskgfor";
        int length = palindrome.length();
        int longestPalindrome = longestPalindrome(palindrome, 0, length - 1, new int[length][length]);
        System.out.println("longestPalindrome = " + longestPalindrome);

        boolean subsequence = isSubsequence( "abc","ahbgdc");
        System.out.println("subsequence = " + subsequence);

        int[] prices = {2,4,1};
        int profit = maxProfit(prices);
        System.out.println("profit = " + profit);
    }

    public static int countAllPossiblePath(boolean[][] grid, int row, int col) {
//        System.out.println("row = " + row + " " + "col = " + col);
        if (!validSquare(grid, row, col)) return 0;
        if (isAtEnd(grid, row, col)) return 1;
        return countAllPossiblePath(grid, row + 1, col) + countAllPossiblePath(grid, row, col + 1);
    }

    private static boolean isAtEnd(boolean[][] grid, int row, int col) {
        return grid.length - 1 == row && grid[0].length - 1 == col;
    }

    private static boolean validSquare(boolean[][] grid, int row, int col) {
        var valid = (row <= grid.length - 1 && col <= grid[0].length - 1) && (grid[row][col]);
        return valid;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] combination = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++) {
            List<String> temp = new ArrayList<>();
            String characters = combination[digits.charAt(digitIndex) - '0'];
            for (int charIndex = 0; charIndex < characters.length(); charIndex++)
                for (String value : result) temp.add(value + characters.charAt(charIndex));
            result = temp;
        }
        if (result.get(0).equals("")) result.remove(0);
        return result;
    }

    public static String longestPalindromeSubstring(String target) {
        // aabacd
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < target.length(); i++) {
            for (int j = i+1; j < target.length(); j++) {
//                System.out.printf("i,j = %d, %d\n", i, j);
                boolean palindrome = isPalindrome(target, i, j);
                if(palindrome) {
                    int currentLength = j-i + 1;
                    int prevLength = rightIndex - leftIndex + 1;
                    if( currentLength > prevLength) {
                        leftIndex = i;
                        rightIndex = j;
                    }
                };
            }
        }
        return target.substring(leftIndex,rightIndex+1);
    }

    private static boolean isPalindrome(String target, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            if(target.charAt(left++) != target.charAt(right--)) return false;
        }
        return true;
    }

    public static int countPossibleCoin(int[] array, int m, int n) {

//     If n is 0 then there is 1
//     solution (do not include any coin)
        if (n == 0)
            return 1;

//     If n is less than 0 then no
//     solution exists
        if (n < 0)
            return 0;

//     If there are no coins and n
//     is greater than 0, then no
//     solution exist
        if (m <= 0 && n >= 1)
            return 0;

//     count is sum of solutions (i)
//     including S[m-1] (ii) excluding S[m-1]
        return countPossibleCoin(array, m - 1, n) + countPossibleCoin(array, m, n - array[m - 1]);
    }


    public static int countPossibleCoinOptimized(int S[], int m, int n) // O(N)
    {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        int table[] = new int[n + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        System.out.println("table = " + Arrays.toString(table));
        return table[n];
    }

    public static int gridTraversal(int row, int column, Map<String, Integer> memo) {
        String key = row + "," + column;
        if (memo.containsKey(key)) return memo.get(key);
        if (row == 1 && column == 1) return 1;
        if (row == 0 || column == 0) return 0;
        var result = gridTraversal(row - 1, column, memo) + gridTraversal(row, column - 1, memo);
        memo.put(key, result);
        return result;
    }

    public static boolean canSome(int target, int[] coins, Map<Integer, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return true;
        if (target < 0) return false;
        for (int number : coins) {
            int diff = target - number;
            if (canSome(diff, coins, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }
    public static List<Integer> howSome(int target, int[] array, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        for (int number : array) {
            int diff = target - number;
            List<Integer> result = howSome(diff, array, memo);
            if (result != null) {
                result.add(number);
                memo.put(target, result);
                return result;
            }
        }
        memo.put(target, null);
        return null;
    }

    public static List<Integer> bestSome(int target, int[] array, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        List<Integer> shortestCombination = null;
        for (int number : array) {
            int diff = target - number;
            List<Integer> result = howSome(diff, array, memo);
            if (result != null) {
                result.add(number);
                if (shortestCombination == null || shortestCombination.size() > result.size()) {
                    shortestCombination = result;
                }
            }
        }
        memo.put(target, shortestCombination);
        return shortestCombination;
    }

    public static List<List<Integer>> allSomeCount(int target, List<Integer> numbers, List<Integer> partition, List<List<Integer>> result) {
       int sum = partition.stream().reduce(0, (a, b) -> a+b);
    // check if the partial sum is equals to target
        if (sum == target) {
            System.out.println("partition = " + partition);
            result.add(partition);
        }
        if (sum >= target) {
            return  result; // if we reach the number why bother to continue
        }

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            List<Integer> remaining = numbers.subList(i,numbers.size());
            partition.add(number);
            allSomeCount(target, numbers, partition, result);
        }
        return result;

    }


    public static boolean canConstruct(String target, List<String> array) {
        if (target.equals("")) return true;
//        if(target < 0) return false;
        for (String item : array) {
            if (target.startsWith(item)) {
                if (canConstruct(target.substring(item.length()), array)) {
                    return true;
                }
                ;
            }
        }
        return false;
    }

    public static int countConstruct(String target, List<String> array) {
        if (target.equals("")) return 1;
        int combinations = 0;
        for (String item : array) {
            if (target.startsWith(item)) {
                int count = countConstruct(target.substring(item.length()), array);
                combinations += count;
            }
        }
        return combinations;
    }


    public static int longestPalindrome(String sequence, int left, int right, int[][] dp) {
        /**
         * Refer: https://www.baeldung.com/cs/longest-palindromic-subsequence-with-dynamic-programming
         *         Algorithm 1: Solve function that finds the longest palindromic sub-sequence
         *         Data: dp: 2D array that stores the answer to states
         *         sequence: The sequence to calculate the answer for
         *         L: The left index of current range
         *         R: The right index of the current range
         *         Result: Returns the longest palindromic subsequence
         */

        if (left > right) {
            return 0;
        } else if (left == right) {
            return 1;
        } else if (dp[left][right] != 0) {
            return dp[left][right];
        } else if (sequence.charAt(left) == sequence.charAt(right)) {
            dp[left][right] = 2 + longestPalindrome(sequence, left + 1, right - 1, dp);
        } else {
            int moveL = longestPalindrome(sequence, left + 1, right, dp);
            int moveR = longestPalindrome(sequence, left, right - 1, dp);
            dp[left][right] = Integer.max(moveL, moveR);
        }
        return dp[left][right];
    }

    public static boolean isSubsequence(String target, String sequence){
//        int i = 0, j = 0;
//        while(j < sequence.length() && i < target.length()) {
//            if(target.charAt(i) == sequence.charAt(j)) {
//                i++;
//            }
//            j++;
//        }
//        return i == target.length();
        if (target.equals("")) return true;
        for (int i = 0, j = 0; j < sequence.length(); j++) {
            if (target.charAt(i) == sequence.charAt(j)) i++;
            if (i == target.length()) return true;
        }
        return false;
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }
        return maxProfit;
//        int sellIndex = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if(prices[i] < prices[sellIndex]) {
//                sellIndex = i;
//            }
//        }
//
//        int buyIndex = sellIndex;
//        for (int i = sellIndex; i < prices.length; i++) {
//            if(prices[i] > prices[buyIndex]) {
//                buyIndex = i;
//            }
//        }
//        return prices[buyIndex] - prices[sellIndex];
    }

    public static void countingBits(){
        int num = 10;
        int[] numbers = new int[num+1];
        for (int i = 0; i <= num; i++) {
            String binaryString = Integer.toBinaryString(i);
            int count = 0;
            for(char item: binaryString.toCharArray()){
                if(item == '1'){
                    count++;
                }
            }
            numbers[i] = count;
        }
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    private static int longestCommonSubsequence(String p, String q, int n, int m){
        /**\
         * LCS
         * P, Q ->
         */

        int result = 0;
        if(n == 0 || m == 0) {
        }
        else if (p.charAt(n-1) == q.charAt(m-1)){
            result = 1 + longestCommonSubsequence(p,q,n-1,m-1);
        }else if (p.charAt(n-1) != q.charAt(n-1)){
            int temp1 = longestCommonSubsequence(p,q,n-1,m);
            int temp2 = longestCommonSubsequence(p,q,n,m-1);
            result = Integer.max(temp1, temp2);
        }
        return result;
    }

//    public static int s

}
