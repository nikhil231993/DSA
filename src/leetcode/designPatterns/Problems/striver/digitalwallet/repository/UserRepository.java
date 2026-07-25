package leetcode.designPatterns.Problems.striver.digitalwallet.repository;

import java.util.Optional;
import leetcode.designPatterns.Problems.striver.digitalwallet.domain.User;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(String userId);
}

