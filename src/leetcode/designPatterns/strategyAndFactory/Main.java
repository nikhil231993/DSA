package leetcode.designPatterns.strategyAndFactory;

public class Main {

    public static void main(String[] args) {

        //In this the payment processor has a strategy but it is composition as the object is created inside it.

        PaymentProcessor paymentProcessor=new PaymentProcessor();
        paymentProcessor.setPaymentprocessor("creditcard");
        paymentProcessor.paymentProcessor();

        paymentProcessor.setPaymentprocessor("debitcard");
        paymentProcessor.paymentProcessor();

        paymentProcessor.setPaymentprocessor("paypal");
        paymentProcessor.paymentProcessor();
    }
}
