package datatype;

import java.util.Locale;

public class StringOperation {
    public static void main(String[] args) {

        System.out.println("reverseWords(\"the sky is blue\") = " + reverseWords("a good   example"));
        
        String str1 = "ABABAB";
        String str2 = "AB";
        System.out.println("gcdOfStrings(str1, str2) = " + gcdOfStrings(str1, str2));

        int[] flowers = {1,0,0,0,1};
        canPlaceFlowers(flowers, 1);

        System.out.println("\n--- STRING OPERATION ---\n");
        String userInput = "    dinesh i     ";
        System.out.println("model.User Input: " + userInput);

        String name = userInput.trim();
        System.out.println("Start and End Whitespace Removed: userInput.trim() :" + name);

        String nameInUppercase = name.toUpperCase(Locale.ROOT);
        System.out.println("Name in UpperCase: " + nameInUppercase);

        String[] firstAndLastName = name.split(" ");
        System.out.println("First Name: " + firstAndLastName[0] + " Last Name: " + firstAndLastName[1]);

        String s1 = new String("Dinesh");
        String s2 = new String("I");
        s1 = s1.replace("n", "*");
        System.out.println("s1 = " + s1);

        String emptyString = "";
        System.out.println("emptyString.isEmpty() = " + emptyString.isEmpty());
        System.out.println("emptyString.isBlank() = " + emptyString.isBlank()); // If is empty or contains only white space

        String literalString = "SAME";
        String newString = new String("SAME");

        System.out.print("newString == literalString = " );
        System.out.println(newString == literalString);

        String concat = "Favorite Number: " + 3;
        System.out.println("concat.substring(0, 2) = " + concat.substring(0, 2)); // end exclusive

    }

    public static String reverseWords(String s) {
        String[] result = s.trim().split(" ");

        StringBuilder builder = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if(result[i].isEmpty())
                continue;
            builder.append(result[i].trim());
            if(i != 0)
                builder.append(" ");
        }

        return builder.toString();
    }

    public static String gcdOfStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for(int i = minLength; i > 0 ; i--) {
            if(!(str1.length() % i == 0 && str2.length()  % i == 0))
                continue;
            String substr = str1.substring(0, i);
            if(padEnd(substr, str1.length(), substr).equals(str1) && padEnd(substr, str2.length(), substr).equals(str2))
                return substr;
        }
        return "";
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = n;

        if(flowerbed.length == 1)
            if(flowerbed[0] == 0)
                count--;

        if(count == 0)
            return true;

        for(int i = 0; i < flowerbed.length; i++) {
            if(i == 0 && (i + 1) < flowerbed.length) {
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0 ) {
                    flowerbed[i] = 1;
                    count--;
                }
            } else if((i - 1) > 0 && i == flowerbed.length - 1) {
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                    flowerbed[i] = 1;
                    count--;
                }
            }
            else if((i - 1) > 0 && (i + 1) < flowerbed.length) {
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0 ) {
                    flowerbed[i] = 1;
                    count--;
                }
            }
        }

        return count <= 0;

    }

    public static String padEnd(String str, int targetLength, String padString) {
        if (str.length() >= targetLength)
            return str;

        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < targetLength) {
            sb.append(padString);
        }

        if (sb.length() > targetLength)
            sb.setLength(targetLength);

        return sb.toString();
    }

}
