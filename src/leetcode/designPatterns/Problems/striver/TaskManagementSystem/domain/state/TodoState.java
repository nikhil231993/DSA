package leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.state;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.Task;
import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.TaskStatus;

public class TodoState implements TaskState {

    @Override
    public boolean canTransitionTo(TaskStatus newStatus) {
        // TODO can transition to IN_PROGRESS or CANCELLED
        return newStatus == TaskStatus.IN_PROGRESS || newStatus == TaskStatus.CANCELLED;
    }

    @Override
    public void performTransition(Task task, TaskStatus newStatus) {
        if (canTransitionTo(newStatus)) {
            task.setStatus(newStatus);
            // TODO: Update state object based on new status
        } else {
            throw new InvalidStateTransitionException("Cannot transition from TODO to " + newStatus);
        }
    }

    @Override
    public String getStateName() {
        return "TODO";
    }
}



