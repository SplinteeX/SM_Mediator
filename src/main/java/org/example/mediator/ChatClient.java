package org.example.mediator;

public interface ChatClient {
    void sendMessage(String message, String receiver);
    void receiveMessage(String sender, String message);
    String getUsername();
}