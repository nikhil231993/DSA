package leetcode.designPatterns.behaviourial.strategyAndFactory;

public class PayPalPayment implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Process Payment via PayPal");
    }
}
