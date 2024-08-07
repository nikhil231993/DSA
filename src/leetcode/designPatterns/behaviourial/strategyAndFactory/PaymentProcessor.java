package leetcode.designPatterns.behaviourial.strategyAndFactory;

public class PaymentProcessor {

    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(){
        this.paymentStrategy=null;
    }

    public void setPaymentProcessor(String payment){

        if(this.paymentStrategy!=null)
            this.paymentStrategy=null;
        this.paymentStrategy=PaymentStrategyFactory.createPaymentClient(payment);
    }

    public void paymentProcessor(){

        if(this.paymentStrategy!=null)
            this.paymentStrategy.processPayment();
        else{
            System.out.println("Could not process payment");
        }
    }
}
