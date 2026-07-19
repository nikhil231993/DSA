package leetcode.designPatterns.Problems.ATMWithdrawal.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class TransactionResult {

    private final String transactionId;
    private final TransactionStatus status;
    private final BigDecimal amount;
    private final Instant processedAt;

    public TransactionResult(
            String transactionId,
            TransactionStatus status,
            BigDecimal amount,
            Instant processedAt) {

        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
        this.processedAt = processedAt;
    }

    public static TransactionResult success(
            BigDecimal amount) {

        return new TransactionResult(
                UUID.randomUUID().toString(),
                TransactionStatus.SUCCESS,
                amount,
                Instant.now());
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getProcessedAt() {
        return processedAt;
    }
}