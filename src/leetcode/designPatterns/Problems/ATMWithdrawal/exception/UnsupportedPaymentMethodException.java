package leetcode.designPatterns.Problems.ATMWithdrawal.exception;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentMethod;

public class UnsupportedPaymentMethodException
        extends RuntimeException {

    public UnsupportedPaymentMethodException(
            PaymentMethod paymentMethod) {

        super(
                "Unsupported payment method: "
                        + paymentMethod
        );
    }
}