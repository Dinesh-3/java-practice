package stream;

import java.math.BigDecimal;
import java.util.List;

public class Usage {
    public static void main(String[] args) {
        List<BigDecimal> decimals = List.of(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN);

        BigDecimal sum = decimals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("sum = " + sum);

        Boolean isInsured = null;
        if(isInsured == Boolean.TRUE) System.out.println("isInsured = " + isInsured);

    }
}
