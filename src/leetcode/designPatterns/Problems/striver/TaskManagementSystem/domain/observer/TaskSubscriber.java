package leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.observer;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.ChangeType;

public interface TaskSubscriber {
    void update(int taskId, ChangeType changeType, String oldValue, String newValue);
}

