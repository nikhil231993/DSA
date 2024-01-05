package leetcode.designPatterns.strategy;

public class PaymentProcessor {

    private PaymentStrategy paymentStrategy;

    public PaymentProcessor() {
        this.paymentStrategy=null;
    }

    public void setPaymentProcessor(PaymentStrategy paymentStrategy){
        if(this.paymentStrategy!=null)
            this.paymentStrategy=null;
        this.paymentStrategy=paymentStrategy;
    }

    public void processPayment(){
        if(this.paymentStrategy!=null)
            this.paymentStrategy.processPayment();
        else
            System.out.println("Cannot do payment");
    }
}
