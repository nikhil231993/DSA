package leetcode.designPatterns.Problems.striver.PubSub.service;

import leetcode.designPatterns.Problems.striver.PubSub.domain.Subscription;
import leetcode.designPatterns.Problems.striver.PubSub.domain.observer.EmailSubscriber;
import leetcode.designPatterns.Problems.striver.PubSub.domain.observer.RealtimeSubscriber;
import leetcode.designPatterns.Problems.striver.PubSub.repository.SubscriberRepository;
import leetcode.designPatterns.Problems.striver.PubSub.repository.SubscriptionRepository;
import leetcode.designPatterns.Problems.striver.PubSub.repository.TopicRepository;

import java.util.UUID;

public class SubscriptionService {
    private SubscriptionRepository subscriptionRepository;
    private SubscriberRepository subscriberRepository;
    private TopicRepository topicRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository,
                               SubscriberRepository subscriberRepository,
                               TopicRepository topicRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriberRepository = subscriberRepository;
        this.topicRepository = topicRepository;
    }

    public Subscription subscribeToTopic(String topicId, String subscriberId) {
        Subscription subscription = new Subscription(UUID.randomUUID().toString(), topicId,
                subscriberId, true, System.currentTimeMillis());
        subscriptionRepository.save(subscription);

        // Add to topic subscriber lists
        topicRepository.findById(topicId).ifPresent(topic -> {
            subscriberRepository.findById(subscriberId).ifPresent(subscriber -> {
                // Always add to email list
                EmailSubscriber emailSub = new EmailSubscriber(subscriber.getEmail());
                topic.getMessageSubject().addEmailSubscriber(emailSub);

                // Add to realtime list if online
                if (subscriber.isOnline()) {
                    RealtimeSubscriber realtimeSub = new RealtimeSubscriber(
                            subscriber.getRealtimeConnectionId(), subscriberId);
                    topic.getMessageSubject().addRealtimeSubscriber(realtimeSub);
                }
            });
        });

        return subscription;
    }

    public void unsubscribeFromTopic(String topicId, String subscriberId) {
        subscriptionRepository.deactivateSubscription(topicId, subscriberId);

        // TODO: Remove from topic subscriber lists
        System.out.println("Unsubscribed " + subscriberId + " from topic " + topicId);
    }
}
