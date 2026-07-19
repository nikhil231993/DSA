package leetcode.designPatterns.Problems.ATMWithdrawal.domain;

import java.math.BigDecimal;

public class TransferRequest {

    private final String sourceAccountId;
    private final String destinationAccountId;
    private final BigDecimal amount;
    private final String idempotencyKey;

    public TransferRequest(
            String sourceAccountId,
            String destinationAccountId,
            BigDecimal amount,
            String idempotencyKey) {

        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
        this.idempotencyKey = idempotencyKey;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }
}
