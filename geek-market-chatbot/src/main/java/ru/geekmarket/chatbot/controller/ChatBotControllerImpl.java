package ru.geekmarket.chatbot.controller;

import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;
import ru.geekmarket.chatbot.service.ChatBotService;

@RestController
public class ChatBotControllerImpl implements ChatBotController {

    private final static Logger logger = LoggerFactory.getLogger(ChatBotControllerImpl.class);

    private final EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    private final ChatBotService chatBotService;

    @Autowired
    public ChatBotControllerImpl(@Lazy EurekaClient eurekaClient, @Lazy ChatBotService chatBotService) {
        this.eurekaClient = eurekaClient;
        this.chatBotService = chatBotService;
    }

    @Override
    public String healthCheck() {
        logger.info("Health check endpoint");
        return eurekaClient.getApplication(appName).getName();
    }

    @Override
    public ChatMessage askChatBot(ChatMessage request) {
        logger.info("New request to chat bot");
        return new ChatMessage(chatBotService.getBotName(), chatBotService.askBot(request.getMessage()));
    }
}
