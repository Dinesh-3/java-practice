import java.text.NumberFormat;

public class MathOperation {
    public static void main(String[] args) {
        float productPrice =  125.05F;
        String priceInDollar = NumberFormat.getCurrencyInstance().format(productPrice).toString();
        System.out.println(priceInDollar);
    }
}
