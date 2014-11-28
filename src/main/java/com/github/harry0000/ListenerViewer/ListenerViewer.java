package com.github.harry0000.ListenerViewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListenerViewer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ListenerViewer.fxml"))));
        stage.show();
    }

}
