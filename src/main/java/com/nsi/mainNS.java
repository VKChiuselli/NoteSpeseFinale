package com.nsi;

import com.nsi.dao.NoteSpeseDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by acerioni on 06/09/2016.
 */
public class mainNS extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Inserisci Note Spese");
        try {
            URL fxmlpath = mainNS.class.getResource("/fxml/NoteSpese.fxml");


            FXMLLoader loader = new FXMLLoader();
            AnchorPane insertNS = loader.load(fxmlpath);


            Scene scene = new Scene(insertNS);
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
      Date date = new Date();

        NoteSpeseDao noteSpeseDao = new NoteSpeseDao();
        boolean res = noteSpeseDao.inserisciNoteSpese(80, date, date, "viaggio1", "bologna", "milano");
        boolean res2 = noteSpeseDao.inserisciNoteSpese(25, date, date, "viaggio2", "acqualagna", "falconara");
        launch(args);




    }


}
