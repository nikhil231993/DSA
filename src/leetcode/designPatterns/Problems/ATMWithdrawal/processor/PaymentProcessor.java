package leetcode.designPatterns.Problems.ATMWithdrawal.processor;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentMethod;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentRequest;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentResult;

public interface PaymentProcessor {

    boolean supports(PaymentMethod paymentMethod);

    PaymentResult process(PaymentRequest request);
}
