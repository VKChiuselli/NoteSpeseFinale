package com.nsi.dao;

import com.nsi.pojo.NoteSpese;
import javafx.collections.ObservableList;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by v.chiuselli on 17/10/2016.
 */
public class NoteSpeseDao extends GenericDao {

    public NoteSpeseDao() {

        super();
    }


    public boolean inserisciNoteSpese(int numero, Object data_dal, Object data_al, String viaggio, String partenza, String ritorno) {

        boolean risposta = false;
        NoteSpese noteSpese = new NoteSpese();
        //noteSpese.setId(id);
        //noteSpese.setId(null);
        noteSpese.setNumero(numero);
        noteSpese.setData_dal(data_dal);
        noteSpese.setData_al(data_al);
        noteSpese.setViaggio(viaggio);
        noteSpese.setPartenza(partenza);
        noteSpese.setRitorno(ritorno);

//
//        noteSpese.setTotali(0);
//        noteSpese.setIva(22);
//        noteSpese.setSpese_rappresentanza(0);
//        noteSpese.setIva_spese_rappresentanza(0);
//        noteSpese.setRimborso_km(0);
//        noteSpese.setDa_pagare(0);
//        noteSpese.setCosto_netto_trasferta(0); //secondo me va calcolato questo.
//        noteSpese.setAllegati(0);
//        noteSpese.setFirma(null);
//        noteSpese.setTipo_automezzo(null);
//        noteSpese.setKm_previsti(0);
//        noteSpese.setCosto_km(0);
//        noteSpese.setData_rimborso_km(null);
//        noteSpese.setTotale_km(0);




        try {
            if(save(noteSpese) != null) {
                risposta = true;
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }





        return risposta;

    }


    public boolean updateNoteSpese( NoteSpese noteSpese)
    {
        boolean risposta= false;




        try {
            save(noteSpese);
                risposta = true;

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

        }
        System.out.println("LA RISPOSTA E'::::::::::::>>>> " + risposta);
return risposta;

    }


    public ObservableList<NoteSpese> caricaNoteSpese(){

        ObservableList<NoteSpese> noteSpeseList;

        noteSpeseList = filtrableQuery("select u from NoteSpese u",null);
        return noteSpeseList ;
    }


}
