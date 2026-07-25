package leetcode.designPatterns.Problems.striver.PubSub.repository;

import leetcode.designPatterns.Problems.striver.PubSub.domain.Message;

import java.util.Optional;

public interface MessageRepository {
    Message save(Message message);
    Optional<Message> findById(String messageId);
    void deleteById(String messageId);
}
