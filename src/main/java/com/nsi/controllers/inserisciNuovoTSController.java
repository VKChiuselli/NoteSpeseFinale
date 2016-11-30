package com.nsi.controllers;

import com.nsi.dao.TipoSpesaDao;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class inserisciNuovoTSController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane insTS;

    @FXML
    private Button salvaTS;

    @FXML
    private TextField ivaField;

    @FXML
    private TextField importoField;

    @FXML
    private TextField descField;

    @FXML
    private Label error1;

    @FXML
    private Label error2;

    @FXML
    private Label error3;

  TipoSpesaDao tsd = new TipoSpesaDao();

    public void SalvaNuovoTS(ActionEvent actionEvent) {

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
            allerta.initOwner(insTS.getScene().getWindow());
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
    @FXML
    void initialize() {
       

    }
}
