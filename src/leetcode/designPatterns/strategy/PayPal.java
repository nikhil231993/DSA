package leetcode.designPatterns.strategy;

public class PayPal implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Processing payment via PayPal");
    }
}
