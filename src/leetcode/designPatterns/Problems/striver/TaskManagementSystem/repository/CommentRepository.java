package leetcode.designPatterns.Problems.striver.TaskManagementSystem.repository;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.Comment;

import java.util.List;

public interface CommentRepository {
    Comment save(Comment comment);
    List<Comment> findByTaskId(int taskId);
}

