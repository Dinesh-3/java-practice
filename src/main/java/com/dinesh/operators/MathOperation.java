package operators;

import java.text.NumberFormat;

public class MathOperation {
    public static void main(String[] args) {
        float productPrice =  125.05f; // 125.05F // both works
        String priceInDollar = NumberFormat.getCurrencyInstance().format(productPrice).toString().toString();
        System.out.println(priceInDollar);
    }
}
