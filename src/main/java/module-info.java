module org.example.mediator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.mediator to javafx.fxml;
    exports org.example.mediator;
}