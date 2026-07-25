package leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.state;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.Task;
import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.TaskStatus;

public class ReviewState implements TaskState {

    @Override
    public boolean canTransitionTo(TaskStatus newStatus) {
        // Can go to COMPLETED, IN_PROGRESS
        return newStatus == TaskStatus.COMPLETED || newStatus == TaskStatus.IN_PROGRESS;
    }

    @Override
    public void performTransition(Task task, TaskStatus newStatus) {
        if (canTransitionTo(newStatus)) {
            task.setStatus(newStatus);
        } else {
            throw new InvalidStateTransitionException(
                    "Cannot transition from REVIEW to " + newStatus);
        }
    }

    @Override
    public String getStateName() {
        return "REVIEW";
    }
}