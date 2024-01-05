package leetcode.designPatterns.strategyAndFactory;

public class DebitCardPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Process Payment via Debit card");
    }
}
