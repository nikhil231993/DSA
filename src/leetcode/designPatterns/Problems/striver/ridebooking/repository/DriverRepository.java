package leetcode.designPatterns.Problems.striver.ridebooking.repository;

import leetcode.designPatterns.Problems.striver.ridebooking.domain.Driver;
import leetcode.designPatterns.Problems.striver.ridebooking.domain.DriverStatus;

import java.util.List;
import java.util.Optional;

public interface DriverRepository {
    Optional<Driver> findById(String id);

    void save(Driver driver);

    List<Driver> findByStatus(DriverStatus status);
}