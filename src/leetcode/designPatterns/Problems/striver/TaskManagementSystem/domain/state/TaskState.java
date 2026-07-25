package leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.state;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.Task;
import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.TaskStatus;

public interface TaskState {
    boolean canTransitionTo(TaskStatus newStatus);
    void performTransition(Task task, TaskStatus newStatus);
    String getStateName();
}