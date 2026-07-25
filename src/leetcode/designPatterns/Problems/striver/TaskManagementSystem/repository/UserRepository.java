package leetcode.designPatterns.Problems.striver.TaskManagementSystem.repository;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.User;

public interface UserRepository {
    User findById(int userId);
}

