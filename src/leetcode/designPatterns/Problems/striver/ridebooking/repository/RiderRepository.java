package leetcode.designPatterns.Problems.striver.ridebooking.repository;

import leetcode.designPatterns.Problems.striver.ridebooking.domain.Rider;

import java.util.Optional;

public interface RiderRepository {
    Optional<Rider> findById(String id);

    void save(Rider rider);
}