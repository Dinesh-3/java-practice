package loop;

import com.google.common.base.Strings;

public class Loop {
    public static void main(String[] args) {
        int[] numbers = {3,2 ,5,9 ,4,3 ,7, 8,8, 4,9, 6,3,4};
        int index = 0;
        int indexDouble = 0;
        for (; index < numbers.length; index++, indexDouble += index) {
            System.out.println("index " + Strings.nullToEmpty("") + " =  "+ index);
            System.out.println("indexDouble = "  + " ".repeat(10) + " =  "+ indexDouble);
        }
    }
}
