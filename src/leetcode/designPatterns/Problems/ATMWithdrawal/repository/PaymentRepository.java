package leetcode.designPatterns.Problems.ATMWithdrawal.repository;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentResult;

public interface PaymentRepository {

    PaymentResult findByIdempotencyKey(
            String idempotencyKey
    );

    void save(
            String idempotencyKey,
            PaymentResult result
    );
}
