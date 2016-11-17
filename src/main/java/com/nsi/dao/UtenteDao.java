package com.nsi.dao;

import com.nsi.pojo.Utente;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by acerioni on 07/09/2016.
 */
public class UtenteDao extends GenericDao{

 public UtenteDao(){
        super();
    }

   public ObservableList<Utente> getAll(){
        ObservableList<Utente> listaUtenti;
        listaUtenti =  filtrableQuery("select u from Utente u",null);
        return listaUtenti;
    }


    public String creaNuovoUtente(String cognome, String nome, String matricola, String ufficio){

        String result = "NOK";

        Utente utente = new Utente();
        utente.setCognome(cognome);
        utente.setNome(nome);
        utente.setMatricola(matricola);
        utente.setUfficio(ufficio);


        try {
            if (save(utente) != null){
               result = "OK";
            }
        }
        catch (RuntimeException e){
            result = e.getMessage();
        }
       return result;


    }

    public List<Utente> findAllUtenti(){

        Utente utente = new Utente();
        return findAll(utente);
    }

    public ObservableList<Utente> findAllObservableUtente(){

        Utente utente = new Utente();
        return findAllObservableList(utente);
    }
}
