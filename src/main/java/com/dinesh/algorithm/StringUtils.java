package algorithm;

import java.util.*;
import java.util.HashMap;
import java.util.stream.Collectors;

public class StringUtils {
    public static void main(String[] args) {
//        char[] letters = { 'a','a','b','b','c','c','c' };
//        compress(letters);

        String s1 = "abc";
        String s2 = "ahbgdc";

        isSubsequence(s1, s2);

//        removeDuplicates("ababa");
//        atoi();
//        longestDistinctSubString();
//        String update = "Dinesh";
//        update.contains(String.valueOf('a'));
//        String input1 = "abcd";
//        String input2 = "cdab";
//        System.out.println("areRotations(input1, input2) = " + areRotations(input1, input2));
//        longestCommonSequence();

//        String one = "1";
//
//        System.out.println("padStart(\"576\", \"0\", 5) = " + padStart("576", "0", 5));
//        findTheOccurrence();

        String reversed = reverseStringOnIChar("string");
        System.out.println("reversed = " + reversed);

    }

    public static boolean isSubsequence(String s, String t) {
        int index = 0;

        for(int i = 0; i < t.length(); i++) {
            if(s.charAt(index) == t.charAt(i))
                index++;
        }

        return index == s.length() - 1;

    }

    public static int compress(char[] chars) {

        int index = 0;
        int count = 1;
        char letter = chars[0];
        for(int i = 1; i < chars.length; i++) {
            if(letter == chars[i])
            {
                count++;
                if(i == chars.length - 1) {
                    chars[index++] = letter;
                    if(count > 1) {
                        char[] arr = (count + "").toCharArray();
                        for (int j = 0; j < arr.length; j++)
                            chars[index++] = arr[j];
                    }
                    count = 1;
                    letter = chars[i];
                }
            }
            else
            {
                chars[index++] = letter;
                if(count > 1) {
                    char[] arr = (count + "").toCharArray();
                    for(int j = 0; j < arr.length; j++)
                        chars[index++] = arr[j];
                }
                count = 1;
                letter = chars[i];
            }
        }

        System.out.println(Arrays.toString(chars));

        return index;
    }

//    public static void combinationMain() {
//        List<Character> letters = List.of('a', 'e', 'i');
//        List<List<Character>> result = combinations(letters);
//    }
//
//    public static List<List<Character>> combinations(List<Character> letters) {
//        for (int i = 0; i < letters.size(); i++) {
//            List<Character> = combinations(letters);
//        }
//        return null;
//    }

    public static void sobDomainVisitCount() {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        Map<String, Integer> domains = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] split = cpdomains[i].split(" ");
            int visitedCount = Integer.parseInt(split[0]);
            String mainDomain = split[1];
            domains.put(mainDomain, domains.getOrDefault(mainDomain,0) + visitedCount);
            for (int j = 0; j < mainDomain.length(); j++) {
                if(mainDomain.charAt(j) == '.') {
                    String subDomain = mainDomain.substring(j+1);
                    domains.put(subDomain, domains.getOrDefault(subDomain, 0) + visitedCount);
                }
            }
            System.out.println("domains = " + domains);
        }
        List<String> stringList = domains.entrySet().stream().map(entry -> String.format("%d %s", entry.getValue(), entry.getKey())).collect(Collectors.toList());
//                .toList(); // JAVA 16
        System.out.println("stringList = " + stringList);
    }
    public static int countVowels(String str) {
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";
        for (var ch : str.toLowerCase().toCharArray())
            if (vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    public static String reverse(String str) {
        if (str == null)
            return "";

        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--)
            reversed.append(str.charAt(i));

        return reversed.toString();
    }

    public static String reverseWords(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static boolean areRotations(
            String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        return (str1.length() == str2.length() &&
                (str1 + str1).contains(str2));
    }

    public static String removeDuplicates(String str) {
        if (str == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

//        for (var ch: str.toCharArray()) // O(N^2)
//            if (output.indexOf(Character.toString(ch)) == -1) output.append(ch);
//        System.out.println(output);

        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }

        return output.toString();
    }

    public static char getMaxOccurringChar(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        int[] counts = new int[26];
        int maxIndex = 0;
        for(char item: str.toCharArray())
            if(++counts[item - 97] > counts[maxIndex])
                maxIndex = item - 97;
        System.out.println( (char) (maxIndex + 97) + " = " + counts[maxIndex]);
        return (char) (maxIndex + 97);
    }

    public static String capitalize(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return "";

        String[] words = sentence
                .trim()
                .replaceAll(" +", " ")
                .split(" ");

        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }


    // O(n log n)
    public static boolean areAnagrams(
            String first, String second
    ) {
        if (first == null || second == null)
            return false;

        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    // O(n)
    public static boolean areAnagram2(
            String first, String second
    ) {
        if (first == null || second == null)
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        first = first.toLowerCase();
        for (var i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;

        second = second.toLowerCase();
        for (var i = 0; i < second.length(); i++) {
            int index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;

            frequencies[index]--;
        }

        return true;
    }

    public static boolean isPalindrome(String word) {
        if (word == null)
            return false;

        int left = 0;
        int right = word.length() - 1;

        while (left < right)
            if (word.charAt(left++) != word.charAt(right--))
                return false;

        return true;
    }

    public static void removeAdjacentDuplicates() {
        /**
         * Recursively remove all adjacent duplicates
         */

        String target = "geeksforgeek";


    }

    public static void atoi() {
        String str = "212";
        try {
            int number = Integer.parseInt(str);
            System.out.println(number);
        }catch (Exception e){
            System.out.println(-1);
        }
    }

    public static void longestDistinctSubString(){
        String word = "aewergrththy";
        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        int count = 0;

        for (char item: word.toCharArray()) {
            if(!set.contains(item)){
                set.add(item);
                count++;
            }
            else {
                set.clear();
                count = 1;
                set.add(item);
            }
            if(maxLength < count) maxLength = count;
        }
        System.out.println("maxLength = " + maxLength);
    }

    private static void longestCommonSequence(){
        String word = "ASSJDHFCCCCCDDDEEEEEEEEEFFEIRU";

        char key = word.charAt(0);
        int max = 1;

        char currentKey = word.charAt(0);
        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            if(word.charAt(i) == currentKey){
                count++;
            }else {
                if(count > max) {
                    max = count;
                    key = currentKey;
                }
                currentKey = word.charAt(i);
                count = 1;
            }
        }

        System.out.println("key count = " + key + " " + max);

    }

    private static String  padStart(String value, String fillContent, int maxLength){

        if ( value.length() > maxLength ) return value;

        StringBuilder builder = new StringBuilder();

        while (builder.length() < ( maxLength - value.length() )){
            builder.append(fillContent);
        }

        builder.append(value);

        return builder.toString();
    }

//    private static String padAt(int index, String value, String fillContent, int maxLength){
//
//    }

    private static void findTheOccurrence() {

        String sentence = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a elementum justo. Suspendisse ut libero scelerisque, congue nibh at, vehicula urna";

        String target = "sit";

        for (int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i) == target.charAt(0)){
                boolean isValid = true;
                for (int sentenceIndex = i, charIndex=0; sentenceIndex < sentence.length() && charIndex < target.length(); sentenceIndex++, charIndex++) {
                    if (!(sentence.charAt(sentenceIndex) == target.charAt(charIndex))) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid){
                    System.out.println("index = " + i);
                    System.out.println("sentence.substring(i, i + target.length()) = " + sentence.substring(i, i + target.length()));
                    break;
                }
            }

        }

    }

    public static String reverseStringOnIChar(String s) {

        StringBuilder builder = new StringBuilder();

        for(char letter: s.toCharArray()) {
            if(letter == 'i')
                builder.reverse();
            else
                builder.append(letter);
        }

        return builder.toString();
    }

}
