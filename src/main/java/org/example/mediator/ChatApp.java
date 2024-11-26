package org.example.mediator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ChatMediator mediator = new ConcreteChatMediator();

        // Create clients
        createClient("User1", mediator);
        createClient("User2", mediator);
        createClient("User3", mediator);
    }

    private void createClient(String username, ChatMediator mediator) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatClient.fxml"));
        Stage stage = new Stage();
        stage.setTitle(username);
        stage.setScene(new Scene(loader.load()));

        ChatClientImpl client = new ChatClientImpl(username, mediator);
        ChatClientController controller = loader.getController();
        controller.initialize(client);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}