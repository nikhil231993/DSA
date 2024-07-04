package leetcode.designPatterns.behaviourial.strategy;

public class CryptoCard implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("Processing payment via Crypto");
    }
}
