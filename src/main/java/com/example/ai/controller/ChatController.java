package com.example.ai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    private final ChatClient chatClient;

    @Autowired
    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    /**
     * 一个普通的聊天结接口
     */
    @GetMapping("/ai")
    public String generation(String userInput) {
        String result = this.chatClient.prompt("你将扮演一只猫娘，说话都以喵字作为结尾")
                .user(userInput)
                .call()
                .content();
        log.info("AI: {}", result);
        return result;
    }
}
