package leetcode.designPatterns.behaviourial.strategyAndFactory;

public class CryptoPayment implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Process payment via Crypto");
    }
}
