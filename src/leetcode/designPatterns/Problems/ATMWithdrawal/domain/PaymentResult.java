package leetcode.designPatterns.Problems.ATMWithdrawal.domain;

import java.math.BigDecimal;

public class PaymentResult {

    private final String paymentId;
    private final PaymentStatus status;
    private final BigDecimal amount;
    private final String message;

    public PaymentResult(
            String paymentId,
            PaymentStatus status,
            BigDecimal amount,
            String message) {

        this.paymentId = paymentId;
        this.status = status;
        this.amount = amount;
        this.message = message;
    }

    public static PaymentResult success(
            String paymentId,
            BigDecimal amount) {

        return new PaymentResult(
                paymentId,
                PaymentStatus.SUCCESS,
                amount,
                "Payment completed successfully"
        );
    }

    public static PaymentResult pending(
            String paymentId,
            BigDecimal amount) {

        return new PaymentResult(
                paymentId,
                PaymentStatus.PENDING,
                amount,
                "Payment is being processed"
        );
    }

    public static PaymentResult failed(
            String paymentId,
            BigDecimal amount,
            String message) {

        return new PaymentResult(
                paymentId,
                PaymentStatus.FAILED,
                amount,
                message
        );
    }

    public String getPaymentId() {
        return paymentId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }
}
