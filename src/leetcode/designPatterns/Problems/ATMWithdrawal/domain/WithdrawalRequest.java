package leetcode.designPatterns.Problems.ATMWithdrawal.domain;

import java.math.BigDecimal;

public class WithdrawalRequest {

    private final String accountId;
    private final BigDecimal amount;
    private final String idempotencyKey;

    public WithdrawalRequest(
            String accountId,
            BigDecimal amount,
            String idempotencyKey) {

        this.accountId = accountId;
        this.amount = amount;
        this.idempotencyKey = idempotencyKey;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }
}