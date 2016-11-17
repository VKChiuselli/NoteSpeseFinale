package com.nsi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by acerioni on 15/09/2016.
 */
public class mainFxml extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlPath = mainFxml.class.getResource("/fxml/DettaglioUtente.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlPath);
        VBox root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dettaglio Utente");
        primaryStage.show();
    }
}