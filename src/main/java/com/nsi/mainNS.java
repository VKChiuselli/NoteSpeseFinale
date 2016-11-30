package com.nsi;

import com.nsi.dao.NoteSpeseDao;
import com.nsi.dao.TipoSpesaDao;
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
            URL fxmlpath = mainNS.class.getResource("/fxml/mixTipiNote.fxml");


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

        TipoSpesaDao dao = new TipoSpesaDao();
        
         dao.inserisciTipoSpesa("uffa", "1.000", "22%");
        dao.inserisciTipoSpesa("altro", "87", "12%");
        dao.inserisciTipoSpesa("dai", "a000", "sdsa%");
 //       boolean res = noteSpeseDao.inserisciNoteSpese("qqq", "123", "456", "viaggio1", "bologna", "milano");
//        boolean res2 = noteSpeseDao.inserisciNoteSpese("www", "asd", "qwert", "viaggio2", "acqualagna", "falconara");
        launch(args);




    }


}
