package leetcode.designPatterns.Problems.ATMWithdrawal.exception;

public class AccountNotFoundException
        extends RuntimeException {

    public AccountNotFoundException(String accountId) {
        super("Account not found: " + accountId);
    }
}