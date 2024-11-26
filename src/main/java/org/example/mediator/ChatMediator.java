package org.example.mediator;

public interface ChatMediator {
    void sendMessage(String message, String sender, String receiver);
    void addClient(ChatClient client);
}