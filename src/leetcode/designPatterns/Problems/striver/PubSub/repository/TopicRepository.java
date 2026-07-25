package leetcode.designPatterns.Problems.striver.PubSub.repository;

import leetcode.designPatterns.Problems.striver.PubSub.domain.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicRepository {
    Topic save(Topic topic);
    List<Topic> findAll();
    Optional<Topic> findById(String topicId);
    void deleteById(String topicId);
}
