package leetcode.designPatterns.Problems.striver.ridebooking.service;

import leetcode.designPatterns.Problems.striver.ridebooking.domain.FareEstimateResponse;
import leetcode.designPatterns.Problems.striver.ridebooking.domain.Location;
import leetcode.designPatterns.Problems.striver.ridebooking.domain.strategy.PricingStrategy;

public class PricingService {
    private final PricingStrategy pricingStrategy;

    public PricingService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public FareEstimateResponse estimateFare(Location pickup, Location dropoff, double distanceKm, long durationSec) {
        long fareMinor = pricingStrategy.calculateFare(pickup, dropoff, distanceKm, durationSec);
        return new FareEstimateResponse(fareMinor, distanceKm, durationSec, "USD");
    }
}