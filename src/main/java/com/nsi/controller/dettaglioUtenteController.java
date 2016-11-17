package com.nsi.controller;

import com.nsi.dao.UtenteDao;
import com.nsi.pojo.Utente;
import javafx.beans.InvalidationListener;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by acerioni on 15/09/2016.
 */
public class dettaglioUtenteController implements Initializable {


    @FXML
    public TableView tableView;
    @FXML
    public TableColumn nomeCella;
    @FXML
    public TableColumn CognomeCella;
    @FXML
    private TextField nomeField;

    @FXML
    private Button CreaBtn;


    @FXML
    public ListView listaUtenti;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        nomeField.setText("Alessandra");
        inizializzaTableView();



    }

     private void inizializzaTableView(){

         UtenteDao udao = new UtenteDao();

         ObservableList<Utente> listaUtenti = udao.findAllObservableUtente();
         listaUtenti.addListener((InvalidationListener) l ->  tableView.setItems(listaUtenti));

         nomeCella.setCellValueFactory(
                 new PropertyValueFactory<Utente,String>("nome")
         );
         CognomeCella.setCellValueFactory(
                 new PropertyValueFactory<Utente,String>("cognome")
         );
         tableView.setItems(listaUtenti);
     }

    public void createUser(ActionEvent actionEvent) {

        String nome = nomeField.getText();

        UtenteDao udao = new UtenteDao();
        udao.creaNuovoUtente(nome,nome,nome,nome);


    }
}
