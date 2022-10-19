package kavya.interview;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Decimal {
    public static void main(String[] args) {
        double value = -0.59817155615240335;
        System.out.println("double value: " + value);
        double newVal = BigDecimal.valueOf(value).setScale(4, RoundingMode.HALF_UP).doubleValue();
        System.out.println("newVal: " + newVal);
    }
}
