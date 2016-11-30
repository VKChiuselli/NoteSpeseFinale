package com.nsi;

import com.nsi.dao.NoteSpeseDao;
import com.nsi.dao.TipoSpesaDao;
import com.nsi.pojo.TipiSpese;
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
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;

/**
 * Created by acerioni on 06/09/2016.
 */
public class mainINS extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Inserisci Note Spese");
        try {
            URL fxmlpath = mainINS.class.getResource("/fxml/listaNoteSpese.fxml");


            FXMLLoader loader = new FXMLLoader();
            AnchorPane insertINS = loader.load(fxmlpath);


            Scene scene = new Scene(insertINS);
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

      NoteSpeseDao dao = new NoteSpeseDao();
       TipoSpesaDao dao2 = new TipoSpesaDao();
        
         dao2.inserisciTipoSpesa("uffa", "1.000", "22%");
        dao2.inserisciTipoSpesa("altro", "87", "12%");
        dao2.inserisciTipoSpesa("dai", "a000", "sdsa%");
   ObservableList<TipiSpese>   listaTS=  dao2.caricaSpese();
      dao.inserisciNoteSpese("agente1", "matricola1", "ufficio1", "partenza1", "ritorno1", "viaggio1", listaTS);
     
      
      
        launch(args);




    }


}
