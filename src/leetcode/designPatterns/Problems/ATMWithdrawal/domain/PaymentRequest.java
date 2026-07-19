package leetcode.designPatterns.Problems.ATMWithdrawal.domain;

import java.math.BigDecimal;

public class PaymentRequest {

    private String customerId;
    private BigDecimal amount;
    private String currency;
    private PaymentMethod paymentMethod;
    private String idempotencyKey;

    public PaymentRequest() {
    }

    public PaymentRequest(
            String customerId,
            BigDecimal amount,
            String currency,
            PaymentMethod paymentMethod,
            String idempotencyKey) {

        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.idempotencyKey = idempotencyKey;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }
}
