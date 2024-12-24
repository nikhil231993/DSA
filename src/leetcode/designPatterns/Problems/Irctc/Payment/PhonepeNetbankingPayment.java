package leetcode.designPatterns.Problems.Irctc.Payment;

public class PhonepeNetbankingPayment extends NetBankingPayment {

    @Override
    public void ProcessNetBankingPayment(double amount) {
        System.out.println("Using Phonepe net banking payment");
    }
}
