package leetcode.designPatterns.Problems.striver.ridebooking.domain.strategy;

import leetcode.designPatterns.Problems.striver.ridebooking.domain.Driver;
import leetcode.designPatterns.Problems.striver.ridebooking.domain.Location;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDrivers(Location pickup, List<Driver> candidates, int maxResults);
}