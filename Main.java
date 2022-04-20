
import exception.UserException;
import model.Manager;
import model.User;
import utils.Console;
import utils.GenericList;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static tricky.TrickyJava.objectRelation;
public class Main {
    /**
     * JAR -> Java ARchive
     * WAR -> Web Application Archive or Web Application Resource
     * EAR -> Enterprise Archive file
     *
     * Community Links:
     * 1. Java Community Process -> https://www.jcp.org/en/home/index
     * 2. Java Specifications Request
     *      -> https://stackoverflow.com/questions/9901976/what-is-jsr-and-whats-its-use
     *      -> https://jcp.org/en/jsr/overview
     * JAX-RS:
     *  Jakarta RESTful Web Services . Specifications for building RESTful services.
     *  Implementation -> RESTEasy, Jersey
     *      Links -> https://www.baeldung.com/rest-api-jax-rs-vs-spring
     */
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        objectRelation();



        List<Integer> as = new ArrayList<>(List.of(1,2,3,5,4));

        for (int i = 0; i < 10; i++) {
            as.add(i);
            as.remove(1);
        }

        ListIterator<Integer> integerListIterator = as.listIterator(as.size());
        while (integerListIterator.hasPrevious()){
            System.out.print(integerListIterator.previous() + " ");
        }
        System.out.println();
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
//        model.User user1 = new model.User("Dinesh", "I", (byte) 10);
//        model.User user2 = user1;
//        user1.setAge((byte) 20);
//        System.out.println("user1 = " + user1.getAge());
//        System.out.println("user2 = " + user2.getAge());
        String s1 = "Dinesh";
        String d = s1.replace("D", "*");
        String s2 = s1;

        System.out.println("d = " + d);
        System.out.println("s2 = " + s2);
        Console.log("Dinesh", "I", "V", 1, 3);

        Main main = new Main();
        main.numberOperations();
        main.arrayOperations();
        main.userLogin();
        main.stringOperations();
        main.conditionalStatement();
        main.fizzBuzz();

//        var laptop = new model.Laptop("HP", 100_000, (byte) 8, 512, LocalDateTime.now());
//        String laptopName = laptop.getName();
//        System.out.println(laptopName);
//        LampdaExpression.main();
        // ThreadPractise.main();

//        String s1 = new String("Dinesh");
//        String s2 = new String("I");
//        s1 = s1.replace("n", "*");
//        System.out.println("s1 = " + s1);

        User user1 = new User("Dinesh", "I", (byte) 21);
        User user2 = new User("Dinesh", "I", (byte) 21);
        boolean equals = user1.equals(user2);
        System.out.println(user1 == user2);
        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();
        System.out.println("hashCode = " + hashCode1 + " " + hashCode2);
        System.out.println("equals = " + equals);
        Console.log("Dinesh", "I", 9, 8, 7);

        List list = new ArrayList<>();
        list.add("Dinesh");
        list.add(1);
        list.add(0.1F);
        list.add(true);
        try {
            list.add(new User("Dinesh", "I", (byte) 1));
        } catch (UserException e) {
            e.printStackTrace();
        }
        for(var item: list) {
            if(item instanceof String) System.out.println("String " + item);
            if(item instanceof User) System.out.println("User " + ((User) item).getFirstName());
            System.out.println("item = " + item.getClass());
        }

        var manager = new Manager("Dinesh", "I", (byte) 20);
        User user = new User("Dinesh", "I", (byte) 1);
        User[] users = { manager, user };
        String firstName = manager.getFirstName();
        System.out.println("firstName = " + firstName);

        GenericList<String> genericList = new GenericList<>();
        genericList.add("Dinesh");
        genericList.add("I");
        genericList.add("F");
        for(var item: genericList) System.out.println("item = " + item);

    }

    public void numberOperations(){
        System.out.println("\n--- NUMBER OPERATION ---\n");
        final byte MONTHS_IN_YEAR = 12;
        final short averageSalary = 32_767;
        int companyRevenue = 2_147_483_647;
        long starsInSpace = 9_223_372_036_854_775_806L;
        float productPrice =  125.0000005F;
        double stackPrice = 12555.878857575758585D;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String priceInRupee = currency.format(productPrice);
        Locale[] availableLocales = NumberFormat.getAvailableLocales();
//        for (Locale locale: availableLocales) {
//            System.out.println("locale.getCountry() = " + locale.getCountry());
//        }
        NumberFormat US = NumberFormat.getCurrencyInstance(Locale.US);
        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat india  = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china  = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("india.format(productPrice) = " + india.format(productPrice));
        System.out.println("china.format(productPrice) = " + china.format(productPrice));
        System.out.println("france.format(productPrice) = " + france.format(productPrice));
        System.out.println("priceInRupee = " + priceInRupee);
        System.out.println("availableLocales = " + Arrays.toString(availableLocales));
        System.out.println(US.format(productPrice));
        float price1 = 0;
        System.out.println("US = " + price1);
    }

    public void arrayOperations(){
        System.out.println("\n--- ARRAY OPERATION ---\n");
        final String[] MONTHS = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
        System.out.println(MONTHS);
        System.out.println(Arrays.asList(MONTHS));
    }

    public void stringOperations(){
        System.out.println("\n--- STRING OPERATION ---\n");
        String userInput = "    dinesh i     ";
        System.out.println("model.User Input: " + userInput);
        String name = userInput.trim();
        System.out.println("Start and End Whitespace Removed: userInput.trim() :" + name);
        String nameInUppercase = name.toUpperCase(Locale.ROOT);
        System.out.println("Name in UpperCase: " + nameInUppercase);
        String[] firstAndLastName = name.split(" ");
        System.out.println("First Name: " + firstAndLastName[0] + " Last Name: " + firstAndLastName[1]);

    }

    public void conditionalStatement(){
        System.out.println("\n--- CONDITIONAL STATEMENT ---\n");
        final int HIGH_INCOME = 100_000;
        final int AVERAGE_INCOME = 50_000;
        final int LOW_INCOME = 25_000;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Monthly Income: ");
        int userIncome = scanner.nextInt();
        boolean isHighIncome = (userIncome >= HIGH_INCOME);

        String incomeStatement = isHighIncome ? "Your Income is High" : "Your Income is Low";

        System.out.println(incomeStatement);

    }

    public void fizzBuzz(){
        System.out.println("--- FIZZ BUZZ GAME ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("ENTER NUMBER: ");
        int number = scanner.nextInt();

        String result = findFizzBuzz(number);

        System.out.println("RESULT: " + result);

    }

    private String findFizzBuzz(int number) {
        if (number %5 ==0 && number %3 == 0) return "FIZZBUZZ";
        if (number %5 == 0) return "FIZZ";
        if (number %3 == 0) return "BUZZ";
        return String.valueOf(number);
    }


    public void userLogin(){
        System.out.println("\n--- USER LOGIN ---\n");
        Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        String email;
        email = getEmailFromUser(EMAIL_PATTERN);
        System.out.print("ENTER PASSWORD: ");
        String password = scanner.nextLine();
        System.out.println("EMAIL: " + email + " PASSWORD: " + password);
    }

    private String getEmailFromUser(Pattern EMAIL_PATTERN) {
        while (true){
            System.out.print("ENTER EMAIL: ");
            String email = scanner.nextLine();
            Matcher matcher = EMAIL_PATTERN.matcher(email);
            if(matcher.matches()) return email;
            System.out.println("WRONG EMAIL, TRY AGAIN");
        }
    }

    public void mortgageCalculator(){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        boolean isEligible = true;
//        boolean b = !!!isEligible;
//        int i = ~10;
//        System.out.println("i = " + i);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }


    public Optional<?> optionalFeature() {
//        Optional.of("Dinesh");
//        Optional.ofNullable("Dinesh");
//        return Optional.empty();
        return Optional.of("Dinesh");
    }

}
