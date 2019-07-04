package ru.geekmarket.chatbot.service;

public interface ChatBotService {

    String getBotName();

    String askBot(String request);
}
