package leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.strategy;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.Task;

import java.util.List;

public class TaskSortingContext {
    private TaskSortingStrategy strategy;

    public void setSortingStrategy(TaskSortingStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Task> sortTasks(List<Task> tasks) {
        if (strategy == null) {
            // Default to priority sorting
            strategy = new PrioritySortingStrategy();
        }
        return strategy.sort(tasks);
    }
}

