package leetcode.designPatterns.Problems.ATMWithdrawal.repository;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@Repository
public class InMemoryPaymentRepository
        implements PaymentRepository {

    private final Map<String, PaymentResult>
            payments =
            new ConcurrentHashMap<>();

    @Override
    public PaymentResult findByIdempotencyKey(
            String idempotencyKey) {

        return payments.get(idempotencyKey);
    }

    @Override
    public void save(
            String idempotencyKey,
            PaymentResult result) {

        payments.put(
                idempotencyKey,
                result
        );
    }
}
