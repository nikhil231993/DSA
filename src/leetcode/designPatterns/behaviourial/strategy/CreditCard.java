package leetcode.designPatterns.behaviourial.strategy;

public class CreditCard implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("Processing payment via CreditCard");
    }
}
