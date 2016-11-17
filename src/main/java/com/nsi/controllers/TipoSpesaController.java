package com.nsi.controllers;

import com.nsi.dao.TipoSpesaDao;
import com.nsi.dao.UtenteDao;
import com.nsi.main;
import com.nsi.pojo.TipiSpese;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;
import javafx.stage.Window;

import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Optional;

/**
 * Created by b.pesty on 13/09/2016.
 */
public class TipoSpesaController {

    @FXML
    public Label error1;
    @FXML
    public Label error2;
    @FXML
    public Label error3;
    @FXML
    public TextField ivaField;
    @FXML
    public TextField importoField;
    @FXML
    public TextField descField;

    @FXML
    public AnchorPane insertTS;

    TipoSpesaDao tsd = new TipoSpesaDao();

    public void SalvaTipoSpesa(ActionEvent actionEvent) {

        if(controllaCampi()){

        tsd.inserisciTipoSpesa(descField.getText(),importoField.getText(),ivaField.getText());
            error1.setText("");
            descField.clear();
            importoField.clear();
            ivaField.clear();
            Alert informaz = new Alert(Alert.AlertType.INFORMATION);
            informaz.setTitle("Inserimento Spesa");
            informaz.setHeaderText(null);
            informaz.setContentText("Inserimento avvenuto con successo!");

            informaz.showAndWait();
        }
    }



    public boolean controllaCampi(){
        boolean controllo = false;

        if(descField.getText().isEmpty()){
            error1.setText("Campo obbligatorio!!");
            Alert allerta = new Alert(Alert.AlertType.WARNING);
            allerta.initOwner(insertTS.getScene().getWindow());
            allerta.setTitle("Avvertenza");
            allerta.setHeaderText(null);
            allerta.setContentText("Correggere gli errori segnalati");

            allerta.showAndWait();

            return controllo;
        }else if(importoField.getText().isEmpty() || ivaField.getText().isEmpty()  ){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sicuro?");
            alert.setHeaderText(null);
            alert.setContentText("Sei sicuro di voler inserire una spesa senza importo/iva?");

            Optional<ButtonType> risultato = alert.showAndWait();
            if(risultato.get() == ButtonType.OK){
                controllo = true;
            }else{
                controllo = false;
            }

        }else {
            controllo = true;
        }

        return controllo;
}

    public void apriListaVista(ActionEvent actionEvent) {
       try {
           URL fxmlpath = main.class.getResource("/fxml/tipoSpesaList.fxml");
           FXMLLoader loader = new FXMLLoader();
           AnchorPane listaTipoSpesa = loader.load(fxmlpath);

           Stage stoca = new Stage();
           Scene ls = new Scene(listaTipoSpesa);
           //carico il CSS per la lista!
           ls.getStylesheets().add("/css/ListDesign.css");
           stoca.setScene(ls);
           stoca.initOwner(insertTS.getScene().getWindow());
           stoca.initModality(Modality.WINDOW_MODAL);
           stoca.show();



       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
