package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(String userId);
}

