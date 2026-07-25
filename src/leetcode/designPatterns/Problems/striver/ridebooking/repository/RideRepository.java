package leetcode.designPatterns.Problems.striver.ridebooking.repository;

import leetcode.designPatterns.Problems.striver.ridebooking.domain.Ride;
import leetcode.designPatterns.Problems.striver.ridebooking.domain.RideStatus;

import java.util.List;
import java.util.Optional;

public interface RideRepository {
    Optional<Ride> findById(String id);

    void save(Ride ride);

    List<Ride> findByRiderId(String riderId);

    List<Ride> findByDriverId(String driverId);

    List<Ride> findByStatus(RideStatus status);
}