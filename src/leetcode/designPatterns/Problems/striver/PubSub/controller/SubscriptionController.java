package leetcode.designPatterns.Problems.striver.PubSub.controller;

import leetcode.designPatterns.Problems.striver.PubSub.domain.Subscription;
import leetcode.designPatterns.Problems.striver.PubSub.service.SubscriptionService;

public class SubscriptionController {
    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    public Subscription subscribeToTopic(String topicId, String subscriberId) {
        return subscriptionService.subscribeToTopic(topicId, subscriberId);
    }

    public void unsubscribeFromTopic(String topicId, String subscriberId) {
        subscriptionService.unsubscribeFromTopic(topicId, subscriberId);
    }
}
