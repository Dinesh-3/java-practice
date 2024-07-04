package datatype;

//create class ASCIITableExample
public class ASCIITable {
    // main() method start
    public static void main(String[] args) {
        char a = 'a';
        char A = 'A';
        System.out.println("(int) a = " + (int) a);
        System.out.println("(int) A = " + (int) A);

        // design header for the ASCII Table
        System.out.printf("%1$-8s %2$-10s %3$s\n", "Decimal", "ASCII", "Hex");
        // use for loop to print all possible ASCII values
        // set value for min and max ASCII values
        int min = 0;
        int max = 256;
        //for loop
        for (int i = min; i < max; i++) {
            // convert each value into character
            char ch = (char) i;
            String display = "";
            // check whether character is whitespace or not
            if (Character.isWhitespace(ch)) {
                // using switch statement
                switch (ch) {
                    case '\r':
                        display = "\\r";
                        break;
                    case '\t':
                        display = "\\t";
                        break;
                    case '\n':
                        display = "\\n";
                        break;
                    case '\f':
                        display = "\\f";
                        break;
                    case ' ':
                        display = "space";
                        break;
                    default:
                        display = "whitespace";
                        break;
                }
                // detect characters that are not letters, digits and punctuation
            } else if (Character.isISOControl(ch)) {
                // showing control chars
                display = "control";
            } else {
                // showing others chars
                display = Character.toString(ch);
            }
            System.out.printf("%1$-8d %2$-10s %3$s\n", i, display, Integer.toHexString(i));
        }
    }
}
