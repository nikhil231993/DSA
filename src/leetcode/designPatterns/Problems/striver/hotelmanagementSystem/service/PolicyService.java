package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.service;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.Booking;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.CancellationPolicy;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.RefundDecision;

public class PolicyService {
    public RefundDecision evaluateCancellation(Booking booking, CancellationPolicy policy, long nowUtc) {
        long hoursUntilCheckIn = (booking.getCheckInDateUtc() - nowUtc) / (1000 * 60 * 60);

        if (hoursUntilCheckIn < policy.getCutoffHoursBeforeCheckIn()) {
            // Past cutoff, no refund
            return new RefundDecision(0, 0);
        }

        int refundPercent = policy.getRefundPercent();
        long refundAmount = (booking.getTotalAmountMinor() * refundPercent) / 100;

        return new RefundDecision(refundPercent, refundAmount);
    }
}
