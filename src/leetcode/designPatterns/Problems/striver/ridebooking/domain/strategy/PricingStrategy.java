package leetcode.designPatterns.Problems.striver.ridebooking.domain.strategy;

import leetcode.designPatterns.Problems.striver.ridebooking.domain.Location;

public interface PricingStrategy {
    long calculateFare(Location pickup, Location dropoff, double distanceKm, long durationSec);
}