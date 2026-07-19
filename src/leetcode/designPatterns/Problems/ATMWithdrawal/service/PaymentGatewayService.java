package leetcode.designPatterns.Problems.ATMWithdrawal.service;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentRequest;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentResult;
import leetcode.designPatterns.Problems.ATMWithdrawal.exception.InvalidAmountException;
import leetcode.designPatterns.Problems.ATMWithdrawal.exception.UnsupportedPaymentMethodException;
import leetcode.designPatterns.Problems.ATMWithdrawal.processor.PaymentProcessor;
import leetcode.designPatterns.Problems.ATMWithdrawal.repository.PaymentRepository;

import java.math.BigDecimal;
import java.util.List;

public class PaymentGatewayService {

    private final List<PaymentProcessor> paymentProcessors;
    private final PaymentRepository paymentRepository;

    public PaymentGatewayService(
            List<PaymentProcessor> paymentProcessors,
            PaymentRepository paymentRepository) {

        this.paymentProcessors = paymentProcessors;
        this.paymentRepository = paymentRepository;
    }

    public PaymentResult makePayment(PaymentRequest request) {
        validateRequest(request);

        PaymentResult existing =
                paymentRepository.findByIdempotencyKey(
                        request.getIdempotencyKey());

        if (existing != null) {
            return existing;
        }

        PaymentProcessor processor = paymentProcessors.stream()
                .filter(candidate ->
                        candidate.supports(request.getPaymentMethod()))
                .findFirst()
                .orElseThrow(() ->
                        new UnsupportedPaymentMethodException(
                                request.getPaymentMethod()));

        PaymentResult result = processor.process(request);

        paymentRepository.save(
                request.getIdempotencyKey(),
                result);

        return result;
    }

    private void validateRequest(PaymentRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Payment request cannot be null");
        }

        if (request.getAmount() == null ||
                request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException(
                    "Payment amount must be greater than zero");
        }

        if (request.getCurrency() == null ||
                request.getCurrency().isBlank()) {
            throw new IllegalArgumentException(
                    "Currency is required");
        }

        if (request.getPaymentMethod() == null) {
            throw new IllegalArgumentException(
                    "Payment method is required");
        }
    }
}
