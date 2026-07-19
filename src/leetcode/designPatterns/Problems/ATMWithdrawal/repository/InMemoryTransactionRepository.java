package leetcode.designPatterns.Problems.ATMWithdrawal.repository;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.TransactionResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@Repository
public class InMemoryTransactionRepository
        implements TransactionRepository {

    private final Map<String, TransactionResult>
            transactions =
            new ConcurrentHashMap<>();

    @Override
    public TransactionResult findByIdempotencyKey(
            String idempotencyKey) {

        return transactions.get(idempotencyKey);
    }

    @Override
    public void save(
            String idempotencyKey,
            TransactionResult result) {

        transactions.put(
                idempotencyKey,
                result);
    }
}