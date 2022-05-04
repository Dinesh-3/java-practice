package datatype;

import java.util.Locale;

public class StringOperation {
    public static void main(String[] args) {

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
        System.out.println("emptyString.isBlank() = " + emptyString.isBlank());

        String literalString = "SAME";
        String newString = new String("SAME");

        System.out.println("newString == literalString = " + newString == literalString);

        String concat = "Favorite Number: " + 3;

        System.out.println("concat.substring(0, 2) = " + concat.substring(0, 2)); // end exclusive

    }
}
