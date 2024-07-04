package exception;

/**
 * To enable assertions
 * java -ea:arguments OR java -enableassertions:arguments

 */
public class AssertionPractice {
    private static final byte MAX_PERCENTAGE = 110;
    public static void main(String[] args) {

        assert MAX_PERCENTAGE <= 110 : "Percentage Must be <= 100"; // MAX_PERCENTAGE Must be <= 100 otherwise throw error

        System.out.println("MAX_PERCENTAGE = " + MAX_PERCENTAGE);
    }
}
