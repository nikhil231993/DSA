package leetcode.designPatterns.Problems.ATMWithdrawal.processor;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentMethod;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentRequest;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentResult;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentStatus;
import leetcode.designPatterns.Problems.ATMWithdrawal.service.TransferService;

public class BankAccountPaymentProcessor implements PaymentProcessor {

    private final TransferService transferService;

    public BankAccountPaymentProcessor(
            TransferService transferService) {
        this.transferService = transferService;
    }

    @Override
    public boolean supports(PaymentMethod paymentMethod) {
        return paymentMethod == PaymentMethod.BANK_ACCOUNT;
    }

    @Override
    public PaymentResult process(PaymentRequest request) {
        // Convert the payment request into a bank transfer request.
        // Account information would normally be securely resolved
        // using a payment token rather than passed directly.

        return new PaymentResult(
                "generated-payment-id",
                PaymentStatus.SUCCESS,
                request.getAmount(),
                "Success");
    }
}