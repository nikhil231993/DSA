package leetcode.designPatterns.Problems.striver.atm.repository;

import leetcode.designPatterns.Problems.striver.atm.domain.Transaction;
import leetcode.designPatterns.Problems.striver.atm.domain.TransactionStatus;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Transaction save(Transaction transaction);

    Optional<Transaction> findById(String transactionId);

    List<Transaction> findBySession(String sessionId);

    List<Transaction> findByATMAndTimeRange(String atmId, long startTime, long endTime);

    void updateTransactionStatus(String transactionId, TransactionStatus status);
}
