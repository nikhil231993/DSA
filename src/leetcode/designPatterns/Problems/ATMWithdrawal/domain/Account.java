package leetcode.designPatterns.Problems.ATMWithdrawal.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private final String accountId;
    private final String customerId;
    private BigDecimal balance;
    private AccountStatus status;

    public Account(
            String accountId,
            String customerId,
            BigDecimal balance,
            AccountStatus status) {

        this.accountId = Objects.requireNonNull(accountId);
        this.customerId = Objects.requireNonNull(customerId);
        this.balance = Objects.requireNonNull(balance);
        this.status = Objects.requireNonNull(status);
    }

    public synchronized void  withdraw(BigDecimal amount) {

        validateActiveAccount();
        validateAmount(amount);

        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException(
                    "Insufficient balance");
        }

        balance = balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        validateAmount(amount);

        balance = balance.add(amount);
    }

    private void validateAmount(BigDecimal amount) {

        if (amount == null ||
                amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Invalid amount");
        }
    }

    private void validateActiveAccount() {

        if (status != AccountStatus.ACTIVE) {
            throw new IllegalStateException(
                    "Account is not active");
        }
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountStatus getStatus() {
        return status;
    }
}
