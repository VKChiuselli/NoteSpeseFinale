package com.nsi.fxmlController;

import com.nsi.dao.UtenteDao;
import com.nsi.jfxMain;
import com.nsi.pojo.Utente;
import com.nsi.utility.JfxUtility;
import javafx.beans.InvalidationListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by felline on 08/09/2016.
 */
public class ListaUtentiController implements Initializable {

/*Qui mappo i componenti della GUI che mi interessa controllare via codice*/
@FXML
private TableView<Utente> tableView;
@FXML
private TableColumn<Utente, String> fxId;
@FXML
private TableColumn<Utente, String> fxNome;
@FXML
private TableColumn<Utente, String> fxCognome;
@FXML
private TableColumn<Utente, String> fxUfficio;
@FXML
private TableColumn<Utente, String> fxMatricola;
@FXML
private TableColumn<Utente, String> fxDetail;
@FXML
private MenuItem fxInserisci;
@FXML
private MenuItem fxCancella;

/*Se una videata ha anche il dettaglio è probabile che servirà usarlo quindi mi prendo il riferimento al suo frammento
* e lo storo all'inizio*/
private final URL fxmlPathDettaglioUtente = jfxMain.class.getResource("/fxml/dettaglioUtenti.fxml");
/*Il ripieno della videata è proprio del controller che la/lo gestisce quindi lo mettiano qui*/
private ObservableList<Utente> users;
/*Il Dao che Gestise il contenuto della videata potrebbe essere utile quindi lo istanzio all'apertura*/
private UtenteDao utenteDao = new UtenteDao();

@Override
public void initialize(URL location, ResourceBundle resources) {
    /*Qui vanno specificate quali proprietà usare per il ripieno delle celle i nomi devono essere quelli delle
    * proprietà del pojo*/
    users = utenteDao.getAll();

  /*Quando Cambia la composizione della lista aggiorno la tabella*/
    users.addListener((InvalidationListener) c ->
            tableView.getItems().setAll(users)
    );

    /*Gestione Inserimento Utente*/
    fxInserisci.setOnAction(event -> {
        try {
            DettaglioUtentiController dettaglio = JfxUtility.spawnWindow(fxmlPathDettaglioUtente, tableView.getScene().getWindow(), new VBox(), Modality.WINDOW_MODAL);
            dettaglio.setInserimentoNuovo(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

    /*Gestione Cancellazione Utente*/
    fxCancella.setOnAction(event -> {
        Utente userEliminare = tableView.getSelectionModel().getSelectedItem();
        this.utenteDao.delete(userEliminare);
        users.remove(userEliminare);
    });


   /*Questa è una factory per personalizzare le celle della Tabella in particolare la cella dettaglio che deve contenere un bottone
   * che deve aprire il documento corrente in una nuova videata modale e permetterne il salvataggio*/
    Callback<TableColumn<Utente, String>, TableCell<Utente, String>> printColumnCellFactory = //
            new Callback<TableColumn<Utente, String>, TableCell<Utente, String>>() {

                @Override
                public TableCell call(final TableColumn param) {
                    final TableCell cell = new TableCell() {

                        @Override
                        public void updateItem(Object item, boolean empty) {
                            super.updateItem(item, empty);
                            /*Se la riga in oggetto è una riga renderizzata ma vuota NON metto il bottone*/
                            if (empty) {
                                setText(null);
                                setGraphic(null);
                            } else {
                                /*Viene instanziato un nuovo bottone*/
                                final Button btnPrint = new Button("Dettaglio Utente");
                                btnPrint.setOnAction(new EventHandler<ActionEvent>() {

                                    @Override
                                    public void handle(ActionEvent event) {
                                     //questa è la riga su cui è stato cliccato Dettaglio e utente è l'oggetto
                                        Utente item = tableView.getSelectionModel().getSelectedItem();
                                        if (item != null) {
                                            try {
                                                System.out.println(item.getId());
                                                DettaglioUtentiController udc = JfxUtility.spawnWindow(fxmlPathDettaglioUtente, tableView.getParent().getScene().getWindow(), new VBox(), Modality.WINDOW_MODAL);

                                                udc.setUtente(item);

                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                });
                                setGraphic(btnPrint);
                                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                            }
                        }
                    };
                    return cell;
                }
            };

    fxDetail.setCellFactory(printColumnCellFactory);
    fxId.setCellValueFactory(new PropertyValueFactory<>("id"));
    fxNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    fxCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
    fxUfficio.setCellValueFactory(new PropertyValueFactory<>("ufficio"));
    fxMatricola.setCellValueFactory(new PropertyValueFactory<>("matricola"));
    fxDetail.setCellValueFactory(new PropertyValueFactory<>("dettaglio"));
    tableView.getItems().setAll(users);

}
}
