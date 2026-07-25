package leetcode.designPatterns.Problems.striver.VendingMachine.domain.state;

import leetcode.designPatterns.Problems.striver.VendingMachine.domain.PaymentRequest;
import leetcode.designPatterns.Problems.striver.VendingMachine.domain.Transaction;
import leetcode.designPatterns.Problems.striver.VendingMachine.domain.VendingMachine;

public class DispensingState implements VendingMachineState {

    @Override
    public Transaction processPayment(VendingMachine machine, PaymentRequest request) {
        System.out.println("DispensingState: Cannot process new payment while dispensing");
        // Cannot process new payment while dispensing
        return null;
    }

    @Override
    public void cancelPayment(VendingMachine machine, int transactionId) {
        System.out.println("DispensingState: Cannot cancel payment while dispensing");
        // Cannot cancel payment while dispensing
    }

    @Override
    public String getStateName() {
        return "DISPENSING";
    }
}
