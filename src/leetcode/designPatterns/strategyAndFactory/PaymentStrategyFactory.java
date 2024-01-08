package leetcode.designPatterns.strategyAndFactory;

public class PaymentStrategyFactory {

    public static PaymentStrategy createPaymentClient(String payment){
        if(payment.equalsIgnoreCase("creditcard"))
            return new CreditCardPayment();
        else if(payment.equalsIgnoreCase("debitcard"))
            return new DebitCardPayment();
        else if(payment.equalsIgnoreCase("paypal"))
            return new PayPalPayment();
        else
            return new CryptoPayment();
    }
}
