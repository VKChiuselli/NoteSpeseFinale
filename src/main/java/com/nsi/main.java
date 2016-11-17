package com.nsi;

import com.nsi.dao.NoteSpeseDao;
import com.nsi.dao.TipoSpesaDao;
import com.nsi.dao.UtenteDao;
import com.nsi.pojo.NoteSpese;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by acerioni on 06/09/2016.
 */
public class main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Inserisci Spesa");
        try {
            URL fxmlpath = main.class.getResource("/fxml/inserisciTipoSpesa.fxml");


            FXMLLoader loader = new FXMLLoader();
            AnchorPane insertTipoSpesa = loader.load(fxmlpath);


            Scene scene = new Scene(insertTipoSpesa);
            primaryStage.setScene(scene);
            primaryStage.show();
//            Date date = new Date();
//            NoteSpeseDao noteSpeseDao = new NoteSpeseDao();
//            boolean res = noteSpeseDao.inserisciNoteSpese(1, date, date, "viaggio1", "bologna", "milano");



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        launch(args);
       /* BigDecimal stoca = new BigDecimal("147.55");
        BigDecimal stica = new BigDecimal("12");

        UtenteDao nuovoUtente = new UtenteDao();

        TipoSpesaDao tipoSpesaDAO = new TipoSpesaDao();

        tipoSpesaDAO.inserisciTipoSpesa("Ale",stoca ,stica);*/

    }
}
