
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        User user1 = new User("Dinesh", "I", (byte) 10);
//        User user2 = user1;
//        user1.setAge((byte) 20);
//        System.out.println("user1 = " + user1.getAge());
//        System.out.println("user2 = " + user2.getAge());
        String s1 = "Dinesh";
        String d = s1.replace("D", "*");
        String s2 = s1;

        System.out.println("d = " + d);
        System.out.println("s2 = " + s2);
        Console.log("Dinesh", "I", "V");

        System.out.println("new UserExample(\"new\") = " + new UserExample("new"));



//        Main main = new Main();
//        main.numberOperations();
//        main.arrayOperations();
//        main.userLogin();
//        main.stringOperations();
//        main.conditionalStatement();
//        main.fizzBuzz();

//        var laptop = new Laptop("HP", 100_000, (byte) 8, 512, LocalDateTime.now());
//        String laptopName = laptop.getName();
//        System.out.println(laptopName);
//        LampdaExpression.main();
        // ThreadPractise.main();

//        String s1 = new String("Dinesh");
//        String s2 = new String("I");
//        s1 = s1.replace("n", "*");
//        System.out.println("s1 = " + s1);

//        User user1 = new User("Dinesh", "I");
//        User user2 = new User("Dinesh", "I");
//        boolean equals = user1.equals(user2);
//        System.out.println(user1 == user2);
//        int hashCode1 = user1.hashCode();
//        int hashCode2 = user2.hashCode();
//        System.out.println("hashCode = " + hashCode1 + " " + hashCode2);
//        System.out.println("equals = " + equals);
//        Print.print("Dinesh", "I", 9, 8, 7);

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
            if(item instanceof User) System.out.println("String " + ((User) item).getFirstName());
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
        NumberFormat US = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("availableLocales = " + Arrays.toString(availableLocales));
//        System.out.println(US.format(productPrice));
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
        System.out.println("User Input: " + userInput);
        String name = userInput.trim();
        System.out.println("Start and End Whitespace Removed: " + name);
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

        String result = String.valueOf(number); // OR DATA_TYPE.toString(number)

        if (number%5 ==0 && number%3 == 0) result = "FIZZBUZZ";
        else if (number%5 == 0) result = "FIZZ";
        else if (number%3 == 0) result = "BUZZ";

        System.out.println("RESULT: " + result);

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


}
