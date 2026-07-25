package leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.observer;

import leetcode.designPatterns.Problems.striver.TaskManagementSystem.domain.ChangeType;

public interface TaskSubject {
    void attach(TaskSubscriber subscriber);
    void detach(TaskSubscriber subscriber);
    void notifySubscribers(ChangeType changeType, String oldValue, String newValue);
}