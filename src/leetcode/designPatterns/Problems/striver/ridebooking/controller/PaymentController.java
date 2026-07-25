package leetcode.designPatterns.Problems.striver.ridebooking.controller;

import leetcode.designPatterns.Problems.striver.ridebooking.domain.PaymentStatus;
import leetcode.designPatterns.Problems.striver.ridebooking.service.RideService;

public class PaymentController {
    private final RideService rideService;

    public PaymentController(RideService rideService) {
        this.rideService = rideService;
    }

    public void handleCallback(String transactionId, PaymentStatus status) {
        rideService.handlePaymentCallback(transactionId, status);
    }
}
