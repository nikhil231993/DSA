package leetcode.designPatterns.Problems.striver.ridebooking.service.notification;

import leetcode.designPatterns.Problems.striver.ridebooking.domain.NotificationMessage;

public class NotificationService {
    public void send(NotificationMessage message) {
        System.out.println("[Notification] to=" + message.getTo() + " subject=" + message.getSubject() + " body="
                + message.getBody());
    }
}
