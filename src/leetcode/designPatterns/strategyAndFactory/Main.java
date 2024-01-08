package leetcode.designPatterns.strategyAndFactory;

public class Main {

    public static void main(String[] args) {

        //In this the payment processor has a strategy but it is composition as the object is created inside it.

        PaymentProcessor paymentProcessor=new PaymentProcessor();
        paymentProcessor.setPaymentProcessor("creditcard");
        paymentProcessor.paymentProcessor();

        paymentProcessor.setPaymentProcessor("debitcard");
        paymentProcessor.paymentProcessor();

        paymentProcessor.setPaymentProcessor("paypal");
        paymentProcessor.paymentProcessor();
    }
}
