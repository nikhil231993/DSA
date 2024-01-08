package leetcode.designPatterns.strategy;

public class DebitCard implements  PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Processing payment via DebitCard");
    }
}
