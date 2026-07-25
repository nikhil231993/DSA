package leetcode.designPatterns.Problems.striver.PubSub.controller;

import leetcode.designPatterns.Problems.striver.PubSub.service.MessageService;

public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void acknowledgeMessage(String messageId, String subscriberId) {
        messageService.acknowledgeMessage(messageId, subscriberId);
    }
}
