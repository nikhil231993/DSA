package leetcode.designPatterns.Problems.striver.TaskManagementSystem.controller;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.TaskStatus;
import leetcode.designPatterns.Problems.striver.TaskManagementSystem.service.TaskStateService;

public class TaskStateController {
    private TaskStateService taskStateService;

    public TaskStateController(TaskStateService taskStateService) {
        this.taskStateService = taskStateService;
    }

    public void updateTaskStatus(int taskId, TaskStatus newStatus) {
        taskStateService.updateTaskStatus(taskId, newStatus);
    }
}