package org.example.mediator;

import javafx.application.Platform;

public class ChatClientImpl implements ChatClient {
    private String username;
    private ChatMediator mediator;
    private ChatClientController controller;

    public ChatClientImpl(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.addClient(this);
    }

    @Override
    public void sendMessage(String message, String receiver) {
        mediator.sendMessage(message, username, receiver);
    }

    @Override
    public void receiveMessage(String sender, String message) {
        Platform.runLater(() -> controller.displayMessage(sender, message));
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setController(ChatClientController controller) {
        this.controller = controller;
    }
}