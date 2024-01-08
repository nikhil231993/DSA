package leetcode.designPatterns.strategy;

public class CryptoCard implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Processing payment via Crypto");
    }
}
