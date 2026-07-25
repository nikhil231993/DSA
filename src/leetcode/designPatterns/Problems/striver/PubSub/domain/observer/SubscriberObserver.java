package leetcode.designPatterns.Problems.striver.PubSub.domain.observer;

import leetcode.designPatterns.Problems.striver.PubSub.domain.Message;

public interface SubscriberObserver {
    void update(Message message);
}
