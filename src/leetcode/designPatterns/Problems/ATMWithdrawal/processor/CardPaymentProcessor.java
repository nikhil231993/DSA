package leetcode.designPatterns.Problems.ATMWithdrawal.processor;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentMethod;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentRequest;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentResult;

public class CardPaymentProcessor implements PaymentProcessor {

    private final ExternalCardGateway cardGateway;

    public CardPaymentProcessor(ExternalCardGateway cardGateway) {
        this.cardGateway = cardGateway;
    }

    @Override
    public boolean supports(PaymentMethod paymentMethod) {
        return paymentMethod == PaymentMethod.CARD;
    }

    @Override
    public PaymentResult process(PaymentRequest request) {
        return cardGateway.charge(
                request.getAmount(),
                request.getCurrency(),
                request.getIdempotencyKey());
    }
}
