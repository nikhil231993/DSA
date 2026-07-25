package leetcode.designPatterns.Problems.striver.musicstreaming.repository;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(String userId);
    Optional<User> findByEmail(String email);
}
