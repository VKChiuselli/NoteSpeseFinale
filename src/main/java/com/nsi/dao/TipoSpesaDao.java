package com.nsi.dao;
import com.nsi.pojo.TipiSpese;
import javafx.collections.ObservableList;
import java.math.BigDecimal;
import javafx.collections.FXCollections;
/**
 * Created by b.pesty on 12/09/2016.
 */
public class TipoSpesaDao extends GenericDao {
    public TipoSpesaDao() {
        super();
    }
    public boolean inserisciTipoSpesa(String descrizione, String importo, String iva) {

        boolean risposta = false;

        TipiSpese tipoSpesa = new TipiSpese();
        tipoSpesa.setDescrizione(descrizione);
        tipoSpesa.setImporto(importo);
        tipoSpesa.setIva(iva);
        try {
            if (save(tipoSpesa) != null) {
                risposta = true;
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        
         
        return risposta;
    }

    public ObservableList<TipiSpese> caricaSpese() {

        ObservableList<TipiSpese> tipoSpesaList;

        tipoSpesaList = filtrableQuery("select u from TipiSpese u", null);
        return tipoSpesaList;
    }

    public ObservableList<String> mostraDescrizioni() {

        ObservableList<String> descrizione;
        descrizione = filtrableQuery("select descrizione from TipiSpese u", null);

        return descrizione;
    }

    public TipiSpese findTipiSpese(String descrizione)
    {
        TipiSpese spese= null;
        System.out.println("TIPI SPESA: " + caricaSpese().size());
        for(int i=0; 0<caricaSpese().size();  i++)
        if((caricaSpese().get(i).getDescrizione()).equals(descrizione))
            return caricaSpese().get(i);
        
        
        System.out.println("DSIUBUFNOPSIDUBIVNOIMADSVBON///// ANDATO STORTO QUALCOSA ////QB9HNOIWPOMèSFOGIRFHOBèEPDTRHINBOSK");
        return spese;
    }
   
}
