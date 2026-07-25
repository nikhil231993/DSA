package leetcode.designPatterns.Problems.striver.PubSub.controller;

import leetcode.designPatterns.Problems.striver.PubSub.domain.Topic;
import leetcode.designPatterns.Problems.striver.PubSub.service.TopicService;

import java.util.List;

public class TopicController {
    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    public Topic createTopic(String name) {
        // Validate
        return topicService.createTopic(name);
    }

    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    public void deactivateTopic(String topicId) {
        topicService.deactivateTopic(topicId);
    }
}
