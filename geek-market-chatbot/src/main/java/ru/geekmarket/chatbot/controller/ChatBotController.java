package ru.geekmarket.chatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ChatBotController {

    @GetMapping("/")
    String healthCheck();

    @PostMapping("chatbot")
    ChatMessage askChatBot(@RequestBody ChatMessage request);
}
