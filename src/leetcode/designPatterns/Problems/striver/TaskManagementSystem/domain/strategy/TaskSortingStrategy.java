package leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.strategy;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.Task;

import java.util.List;

public interface TaskSortingStrategy {
    List<Task> sort(List<Task> tasks);
    String getStrategyName();
}