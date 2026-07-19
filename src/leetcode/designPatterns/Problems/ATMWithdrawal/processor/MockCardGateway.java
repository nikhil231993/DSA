package leetcode.designPatterns.Problems.ATMWithdrawal.processor;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentResult;

import java.math.BigDecimal;
import java.util.UUID;

//@Component
public class MockCardGateway
        implements ExternalCardGateway {

    @Override
    public PaymentResult charge(
            BigDecimal amount,
            String currency,
            String idempotencyKey) {

        String paymentId =
                "card-" + UUID.randomUUID();

        return PaymentResult.success(
                paymentId,
                amount
        );
    }
}
