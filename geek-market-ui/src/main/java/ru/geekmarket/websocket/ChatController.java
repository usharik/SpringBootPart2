package ru.geekmarket.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.HtmlUtils;

@RestController
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    private final SimpMessagingTemplate template;

    private final RestTemplate restTemplate;

    @Autowired
    public ChatController(SimpMessagingTemplate template, RestTemplate restTemplate) {
        this.template = template;
        this.restTemplate = restTemplate;
    }

    @MessageMapping("/send_message")
    @SendTo("/chat_out/receive_message")
    public ChatMessage messageReceiver(ChatMessage message) throws Exception {
        logger.info("New chat message {}", message);

        ResponseEntity<ChatMessage> result;
        try {
            result = restTemplate.postForEntity("http://GEEK-MARKET-CHATBOT/chatbot", message, ChatMessage.class);
        } catch (RestClientException ex) {
            logger.error("Network error", ex);
            return new ChatMessage("server", "Network error. Try again later.");
        }
        if (result.getStatusCode() == HttpStatus.OK) {
            return result.getBody();
        } else {
            logger.error("Response with HTTP error code {}", result.getStatusCode());
            return new ChatMessage("server", "No response from chat bot service. Try again later.");
        }
    }

    @GetMapping("/test/message")
    public void sendMessage() {
        template.convertAndSend("/chat_out/receive_message", new ChatMessage("Server", "Test message"));
    }

}
