import java.text.NumberFormat;

public class MathOperation {
    public static void main() {
        float productPrice =  125.05F;
        String priceInDollar = NumberFormat.getCurrencyInstance().toString();
        System.out.println(priceInDollar);
    }
}
