package leetcode.designPatterns.Problems.striver.digitalwallet.repository.Impl;

import leetcode.designPatterns.Problems.striver.digitalwallet.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import leetcode.designPatterns.Problems.striver.digitalwallet.domain.User;

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

