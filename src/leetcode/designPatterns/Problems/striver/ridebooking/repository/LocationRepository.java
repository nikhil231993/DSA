package leetcode.designPatterns.Problems.striver.ridebooking.repository;

import leetcode.designPatterns.Problems.striver.ridebooking.domain.Location;

public interface LocationRepository {
    void saveLocation(String driverId, Location location);

    Location getLatestLocation(String driverId);
}