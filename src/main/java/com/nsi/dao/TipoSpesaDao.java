package com.nsi.dao;

import com.nsi.pojo.TipiSpese;
import javafx.collections.ObservableList;

import java.math.BigDecimal;

/**
 * Created by b.pesty on 12/09/2016.
 */
public class TipoSpesaDao extends GenericDao {

    public TipoSpesaDao(){
        super();
    }

    public boolean inserisciTipoSpesa(String descrizione, String importo, String iva) {

        boolean risposta = false;

        TipiSpese tipoSpesa = new TipiSpese();
        tipoSpesa.setDescrizione(descrizione);
        tipoSpesa.setImporto(importo);
        tipoSpesa.setIva(iva);

        try {
            if(save(tipoSpesa) != null) {
                risposta = true;
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }

        return risposta;
    }
    
    public ObservableList<TipiSpese> caricaSpese(){
        
        ObservableList<TipiSpese> tipoSpesaList;

        tipoSpesaList = filtrableQuery("select u from TipiSpese u",null);
        return tipoSpesaList ;
    }

}
