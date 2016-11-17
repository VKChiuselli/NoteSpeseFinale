package com.nsi.fxmlController;

import com.nsi.dao.UtenteDao;
import com.nsi.pojo.Utente;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by felline on 13/09/2016.
 */
public class DettaglioUtentiController implements Initializable {

@FXML
private TextField fxNome;
@FXML
private TextField fxCognome;
@FXML
private TextField fxMatricola;
@FXML
private TextField fxUfficio;
@FXML
private Button fxSaveButton;
@FXML
private VBox fxDettaglioUtente;


private Utente user;

private boolean insertNew = false;

private ObservableList<Utente> listaPannelloPadre;
@Override
public void initialize(URL location, ResourceBundle resources) {

    fxSaveButton.setOnAction(event -> {
        UtenteDao utenteDao = new UtenteDao();
        this.user.setNome(fxNome.getText());
        this.user.setCognome(fxCognome.getText());
        this.user.setMatricola(fxMatricola.getText());
        this.user.setUfficio(fxUfficio.getText());
        if (!insertNew) {
            utenteDao.update(this.user);
        } else {
            utenteDao.save(this.user);
            listaPannelloPadre.add(this.user);
             fxDettaglioUtente.getParent();
        }
    });


}


public void setInserimentoNuovo(ObservableList<Utente> doveAggiungere) {
    insertNew = true;
    this.user = new Utente();
    listaPannelloPadre = doveAggiungere;
}

public void setUtente(Utente u) {
    this.user = u;
    fxNome.setText(u.getNome());
    fxCognome.setText(u.getCognome());
    fxMatricola.setText(u.getMatricola());
    fxUfficio.setText(u.getUfficio());
}

}
