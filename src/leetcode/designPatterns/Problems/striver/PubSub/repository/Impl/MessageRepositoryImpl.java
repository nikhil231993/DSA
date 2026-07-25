package leetcode.designPatterns.Problems.striver.PubSub.repository.Impl;

import leetcode.designPatterns.Problems.striver.PubSub.domain.Message;
import leetcode.designPatterns.Problems.striver.PubSub.repository.MessageRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MessageRepositoryImpl implements MessageRepository {
    private Map<String, Message> messages = new ConcurrentHashMap<>();

    @Override
    public Message save(Message message) {
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Optional<Message> findById(String messageId) {
        return Optional.ofNullable(messages.get(messageId));
    }

    @Override
    public void deleteById(String messageId) {
        messages.remove(messageId);
    }
}
