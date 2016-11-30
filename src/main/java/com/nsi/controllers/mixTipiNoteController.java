package com.nsi.controllers;

import com.nsi.dao.NoteSpeseDao;
import com.nsi.pojo.TipiSpese;
import com.nsi.dao.TipoSpesaDao;
import com.nsi.pojo.NoteSpese;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class mixTipiNoteController {

    @FXML
    private AnchorPane mixPane;

    @FXML
    private Button buttonSalva;

    @FXML
    private TextField agenteField;

    @FXML
    private TextField ufficioField;

    @FXML
    private TextField partenzaField;

    @FXML
    private TextField matricolaField;

    @FXML
    private TextField viaggioField;

    @FXML
    private TextField ritornoField;

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
    private Label error20;

    @FXML
    private Label error21;

    @FXML
    private Label error22;

    @FXML
    private TableView<TipiSpese> tabelMix;

    @FXML
    private TableColumn<TipiSpese, String> idColumn;

    @FXML
    private TableColumn<TipiSpese, String> descrizioneColumn;

    @FXML
    private TableColumn<TipiSpese, Integer> importoColumn;

    @FXML
    private TableColumn<TipiSpese, Integer> ivaCollumn;

    @FXML
    private Button inserisciNuovoTipoSpesa;

    @FXML
    ComboBox<String> TipiSpesecomboBoxMix;

    @FXML
    private Button inserisciTS;

    //spostato tutto da initialite a sopra....
    ObservableList<TipiSpese> lista2 = FXCollections.observableArrayList();
    TipoSpesaDao dao = new TipoSpesaDao();
    // ObservableList<String> listad = dao.mostraDescrizioni();

    @FXML
    public void initialize() {

        dao.caricaSpese();

        TipiSpesecomboBoxMix.setItems(dao.mostraDescrizioni());

    }

    @FXML
    void aggiungiTipoSpesa(ActionEvent event) {

        //  TipiSpese result = cercaNotaSpese(TipiSpesecomboBoxMix.getValue());
        TipiSpese result = null;
        TipoSpesaDao dao = new TipoSpesaDao();
        //    ObservableList<TipiSpese> lista = dao.caricaSpese();

        result = dao.findTipiSpese(TipiSpesecomboBoxMix.getValue());
        //TipiSpesecomboBoxMix.setItems(dao.mostraDescrizioni());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        descrizioneColumn.setCellValueFactory(new PropertyValueFactory<>("Descrizione"));
        importoColumn.setCellValueFactory(new PropertyValueFactory<>("Importo"));
        ivaCollumn.setCellValueFactory(new PropertyValueFactory<>("Iva"));

        if (!(lista2.contains(result))) {
            lista2.add(result);
            tabelMix.setItems(lista2);
        }

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX LISTA" + lista2.get(0).getId());
    }

    @FXML
    void inserisciNuovoTipoSpesa(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/inserisciNuovoTS.fxml"));
            AnchorPane frame = fxmlLoader.load();

            Stage window2 = new Stage();
            Scene ls = new Scene(frame);

            window2.setScene(ls);
            window2.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void salvaNoteTipiSpese(ActionEvent event) {

        NoteSpeseDao dao = new NoteSpeseDao();

        dao.inserisciNoteSpese(agenteField.getText(), matricolaField.getText(), ufficioField.getText(), viaggioField.getText(),
                partenzaField.getText(), ritornoField.getText(), lista2);

        agenteField.clear();
        matricolaField.clear();
        ufficioField.clear();
        viaggioField.getText();
        partenzaField.getText();
        ritornoField.getText();
        
    }

    @FXML
    void mostraTS(ActionEvent event) {

        dao.caricaSpese();

    }

    private TipiSpese cercaNotaSpese(String value) {
        TipiSpese result = null;
        TipoSpesaDao dao = new TipoSpesaDao();
        ObservableList<TipiSpese> lista = dao.caricaSpese();

        System.out.println("caricato il dao nuovamente guardiamo che accade: " + lista.toString());
        for (int i = 0; i < lista.size(); i++) {
            if (value.equals(lista.get(i).getDescrizione())) {
                return lista.get(i);
            }
        }

        System.out.println("strano perchè non trovato nessuna lista con quello che è stato selezionato");
        return result;
    }

}
