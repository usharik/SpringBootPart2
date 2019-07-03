package ru.geekmarket.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // STOMP messages with destination header begins with /chat_in are routed to certain @MessageMapping
        config.setApplicationDestinationPrefixes("/chat_in");
        // Enabling of subscription and broadcasting of messages
        config.enableSimpleBroker("/chat_out");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // HTTP URL for WebSocket handshake
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
