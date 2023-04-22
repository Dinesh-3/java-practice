package utils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertCharToString {
    public String convert(char[] chars) {
        new String(chars);
        String.valueOf(chars);
        String.copyValueOf(chars);
        return Stream.of(chars).map(letter -> letter.toString()).collect(Collectors.joining());
    }
}
