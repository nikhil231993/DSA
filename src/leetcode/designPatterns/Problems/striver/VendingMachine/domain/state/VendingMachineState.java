package leetcode.designPatterns.Problems.striver.VendingMachine.domain.state;

import leetcode.designPatterns.Problems.striver.VendingMachine.domain.PaymentRequest;
import leetcode.designPatterns.Problems.striver.VendingMachine.domain.Transaction;
import leetcode.designPatterns.Problems.striver.VendingMachine.domain.VendingMachine;

public interface VendingMachineState {

    Transaction processPayment(VendingMachine machine, PaymentRequest request);
    void cancelPayment(VendingMachine machine, int transactionId);
    String getStateName();
}
