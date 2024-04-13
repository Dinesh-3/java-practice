package utils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertCharToString {
    public static void main(String[] args) {
        char[] chars = {'q', 'd', 'a', 'c'};
        System.out.println(new String(chars));
        System.out.println("String.valueOf(chars); = " + String.valueOf(chars));
        System.out.println("String.copyValueOf(chars); = " + String.copyValueOf(chars));
    }
    public static String convert(char[] chars) {
        new String(chars);
        String.valueOf(chars);
        String.copyValueOf(chars);
        return Stream.of(chars).map(letter -> letter.toString()).collect(Collectors.joining());
    }
}
