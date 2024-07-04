package leetcode.designPatterns.behaviourial.strategy;

public class Main {

    public static void main(String[] args) {

        //In this case Payment Processor has a relationship with Payment Strategy which is aggregation
        //as the strategy object is created here
        //Here context which is PaymentProcessor is first created

        PaymentProcessor paymentProcessor=new PaymentProcessor();

        PaymentStrategy creditCard=new CreditCard();
        paymentProcessor.setPaymentProcessor(creditCard);
        paymentProcessor.processPayment();

        PaymentStrategy debitCard=new DebitCard();
        paymentProcessor.setPaymentProcessor(debitCard);
        paymentProcessor.processPayment();

        PaymentStrategy crypto=new CryptoCard();
        paymentProcessor.setPaymentProcessor(crypto);
        paymentProcessor.processPayment();
    }
}
