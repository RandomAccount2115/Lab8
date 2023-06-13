package pl.lublin.java.lab8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

        Parent root  = fxmlLoader.load();
        HelloController controller = fxmlLoader.getController();

        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Zdarzenia");
        stage.setScene(scene);
        stage.getScene().setOnKeyPressed((KeyEvent ev) -> controller.handleKeyPressed(ev));

        stage.widthProperty().addListener((obs, ov, nv) -> controller.stageResized());
        stage.heightProperty().addListener((obs, ov, nv) -> controller.stageResized());

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}