package leetcode.designPatterns.Problems.ATMWithdrawal.processor;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentResult;

import java.math.BigDecimal;

public interface ExternalCardGateway {

    PaymentResult charge(
            BigDecimal amount,
            String currency,
            String idempotencyKey
    );
}
