package ru.geekmarket.chatbot.service;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ChatBotServiceImpl implements ChatBotService {

    private static final Logger logger = LoggerFactory.getLogger(ChatBotServiceImpl.class);

    @Value("${chatbot.name}")
    private String botName;

    @Value("${chatbot.trace}")
    private Boolean traceMode;

    @Value("${chatbot.configuration.path}")
    private String configurationPath;

    private Chat chatSession;

    private Bot bot;

    @PostConstruct
    public void setup() {
        MagicBooleans.trace_mode = traceMode;
        bot = new Bot("super", configurationPath);
        chatSession = new Chat(bot);
        bot.brain.nodeStats();
    }

    @Override
    public String getBotName() {
        return botName;
    }

    // https://howtodoinjava.com/ai/java-aiml-chatbot-example/
    // https://code.google.com/archive/p/program-ab/wikis/ProgrammingInterface.wiki
    @Override
    public String askBot(String request) {
        if (MagicBooleans.trace_mode) {
            logger.info("STATE={}:THAT={}:TOPIC={}", request,
                    (chatSession.thatHistory.get(0)).get(0), chatSession.predicates.get("topic"));
        }

        String response = chatSession.multisentenceRespond(request);
        while (response.contains("&lt;")) {
            response = response.replace("&lt;", "<");
        }
        while (response.contains("&gt;")) {
            response = response.replace("&gt;", ">");
        }
        return response;
    }
}
