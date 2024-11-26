package org.example.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteChatMediator implements ChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void sendMessage(String message, String sender, String receiver) {
        if (clients.containsKey(receiver)) {
            // Deliver message to the receiver
            clients.get(receiver).receiveMessage(sender, message);
        } else {
            System.out.println("User " + receiver + " does not exist.");
        }
        // Deliver the message back to the sender
        if (clients.containsKey(sender)) {
            clients.get(sender).receiveMessage("To "+ receiver, message);
        }
    }

    @Override
    public void addClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }
}