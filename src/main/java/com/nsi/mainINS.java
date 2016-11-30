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
import static javafx.application.Application.launch;

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

   
    
    
        launch(args);




    }


}
