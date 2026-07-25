package leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.state;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.Task;
import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.TaskStatus;

public class CancelledState implements TaskState {

    @Override
    public boolean canTransitionTo(TaskStatus newStatus) {
        // Can go to TODO (reactivate)
        return newStatus == TaskStatus.TODO;
    }

    @Override
    public void performTransition(Task task, TaskStatus newStatus) {
        if (canTransitionTo(newStatus)) {
            task.setStatus(newStatus);
        } else {
            throw new InvalidStateTransitionException(
                    "Cannot transition from CANCELLED to " + newStatus);
        }
    }

    @Override
    public String getStateName() {
        return "CANCELLED";
    }
}