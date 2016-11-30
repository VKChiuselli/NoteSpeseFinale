package com.nsi.controller;

import com.nsi.dao.TipoSpesaDao;
import com.nsi.pojo.TipiSpese;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by b.pesty on 15/09/2016.
 */
public class tipoSpesaListController implements Initializable {

    @FXML
    private AnchorPane ListaSC;
    @FXML
    private ListView<TipiSpese> listaSpesa;

    private ObservableList<TipiSpese> spesa;

    TipoSpesaDao tsd = new TipoSpesaDao();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        spesa = tsd.caricaSpese();
        System.out.println(spesa);

        //listaSpesa.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listaSpesa.setItems(spesa);

        listaSpesa.setCellFactory(new Callback<ListView<TipiSpese>, ListCell<TipiSpese>>() {
            @Override
            public ListCell<TipiSpese> call(ListView<TipiSpese> p) {

                ListCell<TipiSpese> cellu = new ListCell<TipiSpese>(){

                    @Override
                    public void updateItem(TipiSpese t,boolean bln){
                        super.updateItem(t,bln);
                        if(t != null){
                            setText(t.getDescrizione() + "|" + t.getImporto() + "|" + t.getIva());
                        }
                    }
                };

                return cellu;
            }
        });


    }


}
