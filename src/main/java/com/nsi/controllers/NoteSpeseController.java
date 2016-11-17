package com.nsi.controllers;

import com.nsi.dao.NoteSpeseDao;
import com.nsi.main;
import com.nsi.pojo.NoteSpese;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

import java.util.*;
import javafx.scene.control.DatePicker;

/**
 * Created by v.chiuselli on 18/10/2016.
 */
public class NoteSpeseController {

    @FXML
    public AnchorPane insertLNS;
    @FXML
    public AnchorPane ListaNSC;

    @FXML
    public TableView<NoteSpese> tableView;


    @FXML
    private URL location;


    @FXML
    public TableColumn<NoteSpese, Integer> fxNumeroColumn;
    @FXML
    public TableColumn<NoteSpese, Date> fxData_dalColumn;
    @FXML
    public TableColumn<NoteSpese, Date> fxData_alColumn;
    @FXML
    public TableColumn<NoteSpese, String> fxViaggioColumn;
    @FXML
    public TableColumn<NoteSpese, String> fxPartenzaColumn;
    @FXML
    public TableColumn<NoteSpese, String> fxRitornoColumn;

    ObservableList<NoteSpese> noteSpese;
    NoteSpeseDao nsd = new NoteSpeseDao();
    NoteSpese notaSpesaSelezionato = new NoteSpese();
    @FXML
    private TextField numeroField;
    @FXML
    private DatePicker data_dalField;
    @FXML
    private DatePicker data_alField;
    @FXML
    private TextField viaggioField;
    @FXML
    private TextField partenzaField;
    @FXML
    private TextField ritornoField;


    /*public void editRaw(MouseEvent event) {


        //   tableView.
        System.out.println("ciao");
    }*/


    @FXML
    public void initialize() {

        fxNumeroColumn.setCellValueFactory(new PropertyValueFactory<NoteSpese, Integer>("numero"));
        fxData_dalColumn.setCellValueFactory(new PropertyValueFactory<NoteSpese, Date>("data_dal"));
        fxData_alColumn.setCellValueFactory(new PropertyValueFactory<NoteSpese, Date>("data_al"));
        fxViaggioColumn.setCellValueFactory(new PropertyValueFactory<NoteSpese, String>("viaggio"));
        fxPartenzaColumn.setCellValueFactory(new PropertyValueFactory<NoteSpese, String>("partenza"));
        fxRitornoColumn.setCellValueFactory(new PropertyValueFactory<NoteSpese, String>("ritorno"));

        noteSpese = nsd.caricaNoteSpese();

        tableView.setItems(noteSpese);


        System.out.println("location: " + location);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            notaSpesaSelezionato = newValue;

            try {


                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/noteSpeseList.fxml"));
                AnchorPane frame = fxmlLoader.load();
                noteSpeseListController c = (noteSpeseListController) fxmlLoader.getController();
                c.nscUNO=notaSpesaSelezionato;
                c.setParametri(notaSpesaSelezionato);
         //       System.out.println(notaSpesaSelezionato.getNumero() + " " + notaSpesaSelezionato.getPartenza());


                Stage window2 = new Stage();
                Scene ls = new Scene(frame);


                window2.setScene(ls);
                window2.show();


            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }


}