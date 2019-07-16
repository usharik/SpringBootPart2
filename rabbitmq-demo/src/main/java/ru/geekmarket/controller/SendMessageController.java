package ru.geekmarket.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekmarket.repr.TextMessage;

@RestController
public class SendMessageController {

    @Value("${msg.exchange.name}")
    private String exchange;

    @Value("${msg.routing.key}")
    private String routingKey;

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public SendMessageController(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("send")
    public String sendMessage(@RequestParam("msg") String msg) {
        rabbitTemplate.convertAndSend(exchange, routingKey, new TextMessage(msg));
        return "Message " + msg + " sent to RabbitMQ";
    }
}
