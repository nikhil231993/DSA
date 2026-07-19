package leetcode.designPatterns.Problems.ATMWithdrawal.exception;

public class InvalidAccountStateException
        extends RuntimeException {

    public InvalidAccountStateException(String message) {
        super(message);
    }
}
