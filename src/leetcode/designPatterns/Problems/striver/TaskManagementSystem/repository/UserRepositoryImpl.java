package leetcode.designPatterns.Problems.striver.TaskManagementSystem.repository;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.User;
import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.UserRole;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private Map<Integer, User> users = new HashMap<>();

    public UserRepositoryImpl() {
        // Pre-populate with some users for demo
        users.put(1, new User(1, "john_doe", "john@example.com", UserRole.USER));
        users.put(2, new User(2, "jane_smith", "jane@example.com", UserRole.ADMIN));
    }

    @Override
    public User findById(int userId) {
        return users.get(userId);
    }
}