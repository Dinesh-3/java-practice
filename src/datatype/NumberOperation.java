package datatype;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class NumberOperation {

    public static void main(String[] args){
        System.out.println("\n--- NUMBER OPERATION ---\n");
        /**
            1byte - 8 bit ( ... 32 16 8 4 2 1) = 2 ^ 8 = 256

            byte	1 byte	    Stores whole numbers from -128 to 127 ( 256 ) = 256 / 2 = 128
            short	2 bytes	    Stores whole numbers from -32,768 to 32,767 = 2 ^ 16 = 65,536
            int	    4 bytes	    Stores whole numbers from -2,147,483,648 to 2,147,483,647
            long	8 bytes	    Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
            float	4 bytes	    Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
            double	8 bytes	    Stores fractional numbers. Sufficient for storing 15 decimal digits
            boolean	1 bit	    Stores true or false values
            char	2 bytes	    Stores a single character/letter or ASCII values
         */
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
}
