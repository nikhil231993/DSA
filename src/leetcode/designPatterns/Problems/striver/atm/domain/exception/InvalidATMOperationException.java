package leetcode.designPatterns.Problems.striver.atm.domain.exception;

public class InvalidATMOperationException extends RuntimeException {
    public InvalidATMOperationException(String message) {
        super(message);
    }
}