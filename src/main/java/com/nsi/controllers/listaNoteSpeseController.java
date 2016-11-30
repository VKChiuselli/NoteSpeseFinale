package com.nsi.controllers;

import com.nsi.dao.NoteSpeseDao;
import com.nsi.pojo.NoteSpese;
import com.nsi.pojo.TipiSpese;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class listaNoteSpeseController {

    @FXML
    private AnchorPane pannelloLNS;

    @FXML
    private TableView<NoteSpese> tableView;

    @FXML
    private TableColumn<NoteSpese, String> agenteColumn = new TableColumn<>("agente");

    @FXML
    private TableColumn<NoteSpese, String> matricolaColumn= new TableColumn<>("matricola");;

    @FXML
    private TableColumn<NoteSpese, String> ufficioColumn= new TableColumn<>("ufficio");;

    @FXML
    private TableColumn<NoteSpese, String> viaggioColumn= new TableColumn<>("viaggio");;

    @FXML
    private TableColumn<NoteSpese, String> partenzaColumn= new TableColumn<>("partenza");;

    @FXML
    private TableColumn<NoteSpese, String> ritornoColumn= new TableColumn<>("ritorno");;

    @FXML
    private TableColumn<NoteSpese, TipiSpese> tipiSpeseColumn= new TableColumn<>("tipiSpesa");;

    NoteSpeseDao dao = new NoteSpeseDao();

    @FXML
    public void initialize() {

      
//       agenteColumn.setCellValueFactory(new PropertyValueFactory<>("agente"));
//        matricolaColumn.setCellValueFactory(new PropertyValueFactory<>("matricola"));
//       ufficioColumn.setCellValueFactory(new PropertyValueFactory<>("ufficio"));
//        partenzaColumn.setCellValueFactory(new PropertyValueFactory<>("partenza"));
//        ritornoColumn.setCellValueFactory(new PropertyValueFactory<>("ritorno"));
//  tipiSpeseColumn.setCellValueFactory(new PropertyValueFactory<>("tipiSpese"));
  ObservableList ol = dao.caricaNoteSpese();
        tableView.setItems(ol);
        NoteSpese noteSpese = (NoteSpese)ol.get(0);
      
        

// tableView.getColumns().addAll(agenteColumn, matricolaColumn, ufficioColumn, viaggioColumn, partenzaColumn, ritornoColumn, tipiSpeseColumn)

     

System.out.println("<<<<<<agente: " + noteSpese.getAgente() + " matricola: " +  noteSpese.getMatricola()+" ufficio: " + noteSpese.getUfficio() );
    }

}
