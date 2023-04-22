package datatype;

public class CharacterOperation {
    public static void main(String[] args) {
        System.out.println(" --- CHAR --- ");
        char char1_UTF8 = '\u0061'; // UTF-8 OR UTF-32
        char char1_ASCII = 97;
        char char2_UTF8 = '\u0041';
        char char2_ASCII = 65;
        System.out.println("char1_UTF8 '\\u0061' = " + char1_UTF8);
        System.out.println("char1_ASCII 97 = " + char1_ASCII);
        System.out.println();
        System.out.println("char2_UTF8 '\\u0041'; = " + char2_UTF8);
        System.out.println("char2_ASCII 65 = " + char2_ASCII);
    }
}
