package ru.geekmarket.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @MessageMapping("/send_message")
    @SendTo("/chat_out/receive_message")
    public ChatMessage messageReceiver(ChatMessage message) throws Exception {
        logger.info("New chat message {}", message);
        return new ChatMessage("server", "Echo: " + HtmlUtils.htmlEscape(message.getMessage()));
    }

}
