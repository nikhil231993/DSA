package leetcode.designPatterns.Problems.striver.PubSub.repository;

import leetcode.designPatterns.Problems.striver.PubSub.domain.DeliveryStatus;
import leetcode.designPatterns.Problems.striver.PubSub.domain.MessageDelivery;

import java.util.List;

public interface MessageDeliveryRepository {
    MessageDelivery save(MessageDelivery delivery);
    List<MessageDelivery> findPendingBySubscriber(String subscriberId);
    void updateDeliveryStatus(String deliveryId, DeliveryStatus status);
    void deleteById(String deliveryId);
}
