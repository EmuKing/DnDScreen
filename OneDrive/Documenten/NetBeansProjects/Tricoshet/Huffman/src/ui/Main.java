package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(final Stage _stage) throws Exception {
        final Parent parent = FXMLLoader.load(getClass().getResource("main.fxml"));
        _stage.setTitle("Huffman Compressor");
        _stage.setScene(new Scene(parent));
        _stage.show();
    }
}