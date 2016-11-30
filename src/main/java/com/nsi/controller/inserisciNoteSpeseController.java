/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsi.controller;

import com.nsi.dao.NoteSpeseDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author v.chiuselli
 */
public class inserisciNoteSpeseController {

    @FXML
    public AnchorPane insertINS;

    @FXML
    private TextField id_utenteField;

    @FXML
    private TextField numeroField;

    @FXML
    private TextField viaggioField;

    @FXML
    private TextField partenzaField;

   
    @FXML
    private DatePicker data_dalField;

    @FXML
    private DatePicker data_alField;

    @FXML
    private TextField ritornoField;

    @FXML
    private TextField totaliField;

    @FXML
    private TextField ivaField;

    @FXML
    private TextField firmaField;

    @FXML
    private TextField iva_spese_rappresentanzaField;

    @FXML
    private TextField spese_rappresentanzaField;

    @FXML
    private TextField costo_netto_trasfertaField;

    @FXML
    private TextField rimborso_kmField;

    @FXML
    private TextField da_pagareField;

    @FXML
    private TextField tipo_automezzoField;

    @FXML
    private TextField costo_kmField;

    @FXML
    private TextField km_previstiField;

    @FXML
    private TextField totale_kmField;

    @FXML
    private TextField allegatiField;

    @FXML
    private TextField totale_rimborso_kmField;

    @FXML
    private DatePicker data_rimborso_kmField;

    @FXML
    private TextField idField;
    
    
    
    @FXML
    private Label error1;

    @FXML
    private Label error2;

    @FXML
    private Label error3;

    @FXML
    private Label error4;

    @FXML
    private Label error5;

    @FXML
    private Label error6;

    @FXML
    private Label error7;

    @FXML
    private Label error8;

    @FXML
    private Label error10;

    @FXML
    private Label error11;

    @FXML
    private Label error12;

    @FXML
    private Label error13;

    @FXML
    private Label error14;

    @FXML
    private Label error15;

    @FXML
    private Label error16;

    @FXML
    private Label error17;

    @FXML
    private Label error18;

    @FXML
    private Label error19;

    @FXML
    private Label error20;

    @FXML
    private Label error21;

    @FXML
    private Label error22;

    NoteSpeseDao noteSpeseDao = new NoteSpeseDao();

    public void salvaNoteSpese(ActionEvent actionEvent) {
        System.out.println("ma ci entro?");
     
        if (controllaCampi()) {

            /*   noteSpeseDao.inserisciNoteSpese(numeroField.getText(),,ivaField.getText());
            error1.setText("");
            descField.clear();
            importoField.clear();
            
            System.out.println("entrato senza errori");
            
            ivaField.clear();
            Alert informaz = new Alert(Alert.AlertType.INFORMATION);
            informaz.setTitle("Inserimento Spesa");
            informaz.setHeaderText(null);
            informaz.setContentText("Inserimento avvenuto con successo!");

            informaz.showAndWait();
            
            */
            
            
            System.out.println("sono entrato");
            
        }
        
        System.out.println("c'è stato qualche cosa vuota, riprovare a inserire!!");
        
        
    }

    private boolean controllaCampi() {
        if (id_utenteField.getText().equals(null)) {

            System.out.println("id utente nullo");
            return false;
        }

        if (numeroField.getText().equals(null)) {

            System.out.println("numero non inserito");
            return false;
        }

        Integer numero = Integer.parseInt(numeroField.getText());

        if (numero <= 0) {
            System.out.println("numero è negativo");
            return false;
        }

        if (data_alField.getValue().equals(null)) {

            System.out.println("data inserita nulla");
            return false;
        }

        if (data_dalField.getValue().equals(null)) {

            System.out.println("data inserita nulla");
            return false;
        }
        //!!!!! controllare se bisogna invertire i campi dal/al !!!!!!!!!!!!
        if ((data_dalField.getValue().compareTo(data_alField.getValue())) == -1) {

            System.out.println("errore nell'inserimento date! Non esiste la macchina del tempo");

            return false;
        }

        if (partenzaField.getText().equals(null)) {

            System.out.println("partenza non inserita");
            return false;
        }

        if (ritornoField.getText().equals(null)) {

            System.out.println("ritorno non inserito");
            return false;
        }

        if (totaliField.getText().equals(null)) {

            System.out.println("totali non inserito");
            return false;
        }

        //riuso numero, ma sarebbe totali
        numero = Integer.parseInt(totaliField.getText());

        if (numero <= 0) {
            System.out.println("totali è negativo");
            return false;
        }

        if (allegatiField.getText().equals(null)) {

            System.out.println("allegati non inseriti");
            return false;
        }

        //riuso numero, ma sarebbe allegati
        numero = Integer.parseInt(allegatiField.getText());

        if (numero <= 0) {
            System.out.println("allegati è negativo");
            return false;
        }

        if (spese_rappresentanzaField.getText().equals(null)) {

            System.out.println("spese_rappresentanza non inseriti");
            return false;
        }

        //riuso numero, ma sarebbe allegati
        numero = Integer.parseInt(spese_rappresentanzaField.getText());

        if (numero <= 0) {
            System.out.println("spese_rappresentanza è negativo");
            return false;
        }

        ////finish interi
        if (costo_netto_trasfertaField.getText().equals(null)) {

            System.out.println("costo_netto_trasferta non inseriti");
            return false;
        }

        //riuso numero, ma sarebbe allegati
        numero = Integer.parseInt(costo_netto_trasfertaField.getText());

        if (numero <= 0) {
            System.out.println("costo_netto_trasferta è negativo");
            return false;
        }
        ////finish interi

        
        
        
        
        
           if (tipo_automezzoField.getText().equals(null)) {

            System.out.println("tipo automezzo nullo");
            return false;
        }

            if (km_previstiField.getText().equals(null)) {

            System.out.println("km_previsti non inseriti");
            return false;
        }

        //riuso numero, ma sarebbe allegati
        numero = Integer.parseInt(km_previstiField.getText());

        if (numero <= 0) {
            System.out.println("km_previsti è negativo");
            return false;
        }
        ////finish interi

        
        
 ///inizio interi
            if (costo_kmField.getText().equals(null)) {

            System.out.println("costo_km non inseriti");
            return false;
        }

        //riuso numero, ma sarebbe allegati
        numero = Integer.parseInt(costo_kmField.getText());

        if (numero <= 0) {
            System.out.println("costo_km è negativo");
            return false;
        }
        ////finish interi

        
        
        
        
        
          if (data_rimborso_kmField.getValue().equals(null)) {

            System.out.println("data_rimborso_km nulla");
            return false;
        }
        
        
        
        
        
        
        
        
        
 ///inizio interi
            if (totale_kmField.getText().equals(null)) {

            System.out.println("totale_km non inseriti");
            return false;
        }

        //riuso numero, ma sarebbe allegati
        numero = Integer.parseInt(totale_kmField.getText());

        if (numero <= 0) {
            System.out.println("totale_km è negativo");
            return false;
        }
        ////finish interi
       
         ///inizio interi
            if (totale_rimborso_kmField.getText().equals(null)) {

            System.out.println("totale_rimborso_km non inseriti");
            return false;
        }

        //riuso numero, ma sarebbe allegati
        numero = Integer.parseInt(totale_rimborso_kmField.getText());

        if (numero <= 0) {
            System.out.println("totale_rimborso_km è negativo");
            return false;
        }
        ////finish interi
       
        return true;
    }

}
