package leetcode.designPatterns.Problems.ATMWithdrawal.repository;


import leetcode.designPatterns.Problems.ATMWithdrawal.domain.TransactionResult;

public interface TransactionRepository {

    TransactionResult findByIdempotencyKey(String idempotencyKey);

    void save(String idempotencyKey, TransactionResult result);
}
