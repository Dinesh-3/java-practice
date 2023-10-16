package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public static void main(String[] args) {
        System.out.println("97 = " + (char) 97);
        System.out.println("123 = " + (char) 122);
        System.out.println("findFirstNonRepeatingChar(\"awheiufaiwuer\") = " + findFirstNonRepeatingChar("awheiufaiwuer"));
        System.out.println("findFirstNonRepeatingChar(\"awheiufaiwuer\") = " + findFirstRepeatedChar("awheiufaiwuer"));

    }

    public static char findFirstNonRepeatingChar(String str) {

        int[] alphabets = new int[26];

        var chars = str.toCharArray();
        for (var ch : chars) {
            alphabets[ch - 97] += 1;
        }

        for (int i = 0; i < alphabets.length; i++) {
            if(alphabets[i] == 1)
                return (char) (i + 97);
        }

        return Character.MIN_VALUE;
    }

    public static char findFirstRepeatedChar(String str) {
        int[] alphabets = new int[26];

        for (var ch : str.toCharArray())
            if (++alphabets[ch - 97] > 1) return ch;

        return Character.MIN_VALUE;
    }

}
