package leetcode.designPatterns.behaviourial.strategyAndFactory;

public class DebitCardPayment implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Process Payment via Debit card");
    }
}
