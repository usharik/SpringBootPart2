package ru.geekmarket.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    private final SimpMessagingTemplate template;

    public ChatController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/send_message")
    @SendTo("/chat_out/receive_message")
    public ChatMessage messageReceiver(ChatMessage message) throws Exception {
        logger.info("New chat message {}", message);
        return new ChatMessage("server", "Echo: " + HtmlUtils.htmlEscape(message.getMessage()));
    }

    @GetMapping("/test/message")
    public void sendMessage() {
        template.convertAndSend("/chat_out/receive_message", new ChatMessage("Server", "Test message"));
    }

}
