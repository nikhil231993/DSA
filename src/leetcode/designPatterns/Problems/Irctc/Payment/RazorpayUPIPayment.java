package leetcode.designPatterns.Problems.Irctc.Payment;

public class RazorpayUPIPayment extends UPIPayment {

    @Override
    public void ProcessUPIPayment(double amount) {
        System.out.println("Using Razorpay UPI Payment");
    }
}
