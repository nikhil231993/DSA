package leetcode.designPatterns.strategyAndFactory;

public class CryptoPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Process payment via Crypto");
    }
}
