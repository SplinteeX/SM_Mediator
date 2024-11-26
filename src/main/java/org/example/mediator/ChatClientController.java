package org.example.mediator;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatClientController {
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;
    @FXML
    private TextField recipientField;

    private ChatClientImpl client;

    public void initialize(ChatClientImpl client) {
        this.client = client;
        client.setController(this);
    }

    public void displayMessage(String sender, String message) {
        messageArea.appendText(sender + ": " + message + "\n");
    }

    @FXML
    private void sendMessage() {
        String recipient = recipientField.getText();
        String message = messageField.getText();
        if (!recipient.isEmpty() && !message.isEmpty()) {
            client.sendMessage(message, recipient);
            messageField.clear();
        }
    }
}
