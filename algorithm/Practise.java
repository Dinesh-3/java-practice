package algorithm;

import java.util.Arrays;

public class Practise {
    public static void main(String[] args) {
        char[] chars = ("afssjzzz").toCharArray();

        int[] counts = new int[26];
        int maxIndex = 0;
        for(char item: chars)
            if(++counts[item - 97] > counts[maxIndex])
                maxIndex = item - 97;

        System.out.println( (char) (maxIndex + 97) + " = " + counts[maxIndex]);
    }
}
