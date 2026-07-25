package leetcode.designPatterns.Problems.striver.PubSub.controller;

import leetcode.designPatterns.Problems.striver.PubSub.domain.Message;
import leetcode.designPatterns.Problems.striver.PubSub.service.PublisherService;

public class PublisherController {
    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public Message publishMessage(String topicId, String content) {
        return publisherService.publishMessage(topicId, content);
    }
}
