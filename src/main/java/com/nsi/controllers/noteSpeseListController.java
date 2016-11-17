package com.nsi.controllers;

import com.nsi.dao.NoteSpeseDao;
import com.nsi.pojo.NoteSpese;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import javax.xml.bind.annotation.XmlType;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EventListener;
import java.util.Locale;
import java.util.ResourceBundle;

import static javax.xml.crypto.dsig.spec.ExcC14NParameterSpec.DEFAULT;

/**
 * Created by v.chiuselli on 18/10/2016.
 */
public class noteSpeseListController /*implements Initializable*/ {


    @FXML
    private Label label_numero;
    @FXML
    private Label label_data_dal;
    @FXML
    private Label label_data_al;
    @FXML
    private Label label_viaggio;
    @FXML
    private Label label_partenza;
    @FXML
    private Label label_ritorno;


    @FXML
    private Button buttonSalva;
    @FXML
    private TextField numeroField;
    @FXML
    private TextField data_dalField;
    @FXML
    private TextField data_alField;
    @FXML
    private TextField viaggioField;
    @FXML
    private TextField partenzaField;
    @FXML
    private TextField ritornoField;


    //    @FXML
//    private ListView<NoteSpese> listaNoteSpese;
//

    // private NoteSpese noteSpese;


    private ObservableList<NoteSpese> noteSpese;

    NoteSpeseDao nsd = new NoteSpeseDao();

    NoteSpese nscUNO = new NoteSpese();


    public void setParametri(NoteSpese noteSpese) {

        System.out.println("setto i parametri PID: " + noteSpese);

        numeroField.setText(Integer.toString(noteSpese.getNumero()));
        data_dalField.setText(noteSpese.getData_dal().toString());
        data_alField.setText(noteSpese.getData_dal().toString());
        viaggioField.setText(noteSpese.getViaggio());
        partenzaField.setText(noteSpese.getPartenza());
        ritornoField.setText(noteSpese.getRitorno());
    }


    @FXML
    public void initialize() {


        System.out.println("Sbagliato PID: " + nscUNO);


        buttonSalva.setOnAction(event -> {


            try {

                Integer numero = Integer.parseInt(numeroField.getText());
                DateFormat format = DateFormat.getDateInstance(DateFormat.DEFAULT);
                Date data1 = format.parse(data_dalField.getText());
                Date data2 = format.parse(data_alField.getText());
                String viaggio = viaggioField.getText();
                String partenza = partenzaField.getText();
                String ritorno = ritornoField.getText();


                nscUNO.setNumero(numero);
                nscUNO.setData_al(data2);
                nscUNO.setData_dal(data1);
                nscUNO.setViaggio(viaggio);
                nscUNO.setPartenza(partenza);
                nscUNO.setRitorno(ritorno);

                //     NoteSpese noteSpese = new NoteSpese(numero, data1, data2, viaggioField.getText(), partenzaField.getText(), ritornoField.getText());
                //      nsd.update(nscUNO);
                //      nsd.updateNoteSpese(numero, data1, data2, viaggioField.getText(), partenzaField.getText(), ritornoField.getText());

                System.out.println("Dopo update PID: " + nscUNO);

                nsd.updateNoteSpese(nscUNO);


            } catch (ParseException e) {
                e.printStackTrace();
            }

        });


//    listaSpesa.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//    listaNoteSpese.setItems(noteSpese);
//
//    listaNoteSpese.setCellFactory(new Callback<ListView<NoteSpese>, ListCell<NoteSpese>>() {
//
//        @Override
//        public ListCell<NoteSpese> call(ListView<NoteSpese> p) {
//
//            ListCell<NoteSpese> cellu = new ListCell<NoteSpese>() {
//
//                @Override
//                public void updateItem(NoteSpese t, boolean bln) {
//                    super.updateItem(t, bln);
//                    if (t != null) {
//                        setText(t.getNumero() + "|" + t.getData_dal() + "|" + t.getData_al() + "|" + t.getViaggio() + "|" + t.getPartenza() + "|" + t.getRitorno());
//                    }
//                }
//            };
//
//            return cellu;
//        }
        //  });


    }


}




