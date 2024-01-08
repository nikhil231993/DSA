package leetcode.designPatterns.strategyAndFactory;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Process Payment via credit card");
    }
}
