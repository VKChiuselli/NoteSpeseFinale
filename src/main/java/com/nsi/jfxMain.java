package com.nsi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by felline on 07/09/2016.
 */
public class jfxMain extends Application {

public static void main(String[] args) {
    Application.launch();
}

@Override
public void start(Stage primaryStage) throws Exception {
    URL fxmlPath = jfxMain.class.getResource("/fxml/listaUtenti.fxml");
    FXMLLoader loader = new FXMLLoader(fxmlPath);
    VBox root = loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Tabella Utenti");
    primaryStage.show();
}
}
