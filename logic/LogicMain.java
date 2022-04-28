package logic;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicMain {
    private Scanner scanner = new Scanner(System.in);

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

}
