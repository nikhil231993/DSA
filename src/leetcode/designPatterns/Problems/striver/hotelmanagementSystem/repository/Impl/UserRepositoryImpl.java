package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository.Impl;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.User;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepositoryImpl implements UserRepository {
    private Map<String, User> users = new ConcurrentHashMap<>();

    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String userId) {
        return Optional.ofNullable(users.get(userId));
    }
}
