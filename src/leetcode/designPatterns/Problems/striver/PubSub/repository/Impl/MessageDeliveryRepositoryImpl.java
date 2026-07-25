package leetcode.designPatterns.Problems.striver.PubSub.repository.Impl;

import leetcode.designPatterns.Problems.striver.PubSub.domain.DeliveryStatus;
import leetcode.designPatterns.Problems.striver.PubSub.domain.MessageDelivery;
import leetcode.designPatterns.Problems.striver.PubSub.repository.MessageDeliveryRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MessageDeliveryRepositoryImpl implements MessageDeliveryRepository {
    private Map<String, MessageDelivery> deliveries = new ConcurrentHashMap<>();

    @Override
    public MessageDelivery save(MessageDelivery delivery) {
        deliveries.put(delivery.getId(), delivery);
        return delivery;
    }

    @Override
    public List<MessageDelivery> findPendingBySubscriber(String subscriberId) {
        return deliveries.values().stream()
                .filter(delivery -> delivery.getSubscriberId().equals(subscriberId) &&
                        delivery.getStatus() == DeliveryStatus.PENDING)
                .collect(Collectors.toList());
    }

    @Override
    public void updateDeliveryStatus(String deliveryId, DeliveryStatus status) {
        MessageDelivery delivery = deliveries.get(deliveryId);
        if (delivery != null) {
            delivery.setStatus(status);
            if (status == DeliveryStatus.ACKNOWLEDGED) {
                delivery.setAcknowledgedAt(System.currentTimeMillis());
            }
        }
    }

    @Override
    public void deleteById(String deliveryId) {
        deliveries.remove(deliveryId);
    }
}
