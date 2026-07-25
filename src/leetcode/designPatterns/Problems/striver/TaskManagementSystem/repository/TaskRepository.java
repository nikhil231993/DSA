package leetcode.designPatterns.Problems.striver.TaskManagementSystem.repository;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.Task;
import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.TaskSearchCriteria;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    Task findById(int taskId);
    List<Task> findByAssignee(int assigneeId);
    List<Task> findByParentTask(int parentTaskId);
    List<Task> search(TaskSearchCriteria criteria);
    void delete(int taskId);
}
