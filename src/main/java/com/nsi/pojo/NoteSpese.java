package com.nsi.pojo;

import javafx.beans.property.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.*;

import java.util.*;

/**
 * Created by v.chiuselli on 14/10/2016.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "NoteSpese")
public class NoteSpese implements Externalizable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "uuid", unique = true)
    private String id;

    @Transient
    @Column(nullable = false)
    private String _agente;

    private StringProperty agente;

    @Transient
    @Column(nullable = false)
    private String _matricola;

    private StringProperty matricola;

    @Transient
    @Column(nullable = false)
    private String _ufficio;

    private StringProperty ufficio;

    @Transient
    @Column(nullable = false)
    private String _viaggio;

    private StringProperty viaggio;

    @Transient
    @Column(nullable = false)
    private String _partenza;

    private StringProperty partenza;

    @Transient
    @Column(nullable = false)
    private String _ritorno;
    private StringProperty ritorno;

   @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipiSpese", nullable = true)
    private Set<TipiSpese> _tipiSpese;

    @Transient
    private SetProperty<TipiSpese> tipiSpese; 

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public NoteSpese(String _agente, String _matricola, String _viaggio, String _partenza, String _ritorno) {
        //this._tipiSpese = tipiSpese;
        this._agente = _agente;
        this._matricola = _matricola;
        this._viaggio = _viaggio;
        this._partenza = _partenza;
        this._ritorno = _ritorno;
    }

    public NoteSpese() {
    }

    @Access(AccessType.PROPERTY)
    public String getAgente() {
        if (this.agente == null) {
            return _agente;
        } else {
            return agente.get();
        }
    }

    public void setAgente(String agente) {
        if (this.agente == null) {
            _agente = agente;
        } else {
            this.agente.set(agente);
        }
    }

    @Access(AccessType.PROPERTY)
    public String getMatricola() {
        if (this.matricola == null) {
            return _matricola;
        } else {
            return matricola.get();
        }
    }

    public void setMatricola(String matricola) {
        if (this.matricola == null) {
            _matricola = matricola;
        } else {
            this.matricola.set(matricola);
        }
    }

    @Access(AccessType.PROPERTY)
    public String getUfficio() {
        if (this.ufficio == null) {
            return _ufficio;
        } else {
            return ufficio.get();
        }
    }

    
      public void setTipiSpese(Set<TipiSpese> c) {
     if (this.tipiSpese == null) {
            _tipiSpese =  tipiSpese;
        } else {
            this.tipiSpese.set((SetProperty)tipiSpese);
        }
    }
    
//    public void setTipiSpese(SetProperty tipiSpese) {
//        if (this.tipiSpese == null) {
//            _tipiSpese = tipiSpese;
//        } else {
//            this.tipiSpese.set(tipiSpese);
//        }}

    

    /*   public void setTipiSpese(Set<TipiSpese>  tipiSpese) {
        if (this.tipiSpese == null) {
            _tipiSpese =  tipiSpese;
        } else {
            this.tipiSpese.set(tipiSpese);
        }
    } */


//    @Access(AccessType.PROPERTY)
//    public Set<TipiSpese> getTipiSpese() {
//        if (this.tipiSpese == null) {
//            return _tipiSpese;
//        } else {
//            return tipiSpese.get();
//        }
//    }

    
public void setUfficio(String ufficio) {
        if (this.ufficio == null) {
            _ufficio = ufficio;
        } else {
            this.ufficio.set(ufficio);
        }

    }
    @Access(AccessType.PROPERTY)
    public String getViaggio() {
        if (this.viaggio == null) {
            return _viaggio;
        } else {
            return viaggio.get();
        }
    }

    public void setViaggio(String viaggio) {
        if (this.viaggio == null) {
            _viaggio = viaggio;
        } else {
            this.viaggio.set(viaggio);
        }
    }

    @Access(AccessType.PROPERTY)
    public String getPartenza() {
        if (this.partenza == null) {
            return _partenza;
        } else {
            return partenza.get();
        }
    }

    public void setPartenza(String partenza) {
        if (this.partenza == null) {
            _partenza = partenza;
        } else {
            this.partenza.set(partenza);
        }
    }

    /* @Access(AccessType.PROPERTY)
    public TipiSpese getTipiSpese() {
        if (this.tipiSpese == null) {
            return _tipiSpese;
        } else {
            return (TipiSpese)tipiSpese.get();
        }
    }

    
    
    
      public SimpleObjectProperty tipiSpeseProperty() {
        if (tipiSpese == null) {
            tipiSpese = new SimpleObjectProperty(this, "tipiSpese", _tipiSpese);
        }
        return (SimpleObjectProperty) tipiSpese;
    }
     */
 /*public String getId_utente() {
        if (this.id_utente == null) {
            return _id_utente;
        } else {
            return id_utente.get();
        }
    }

    public void setId_utente(String id_utente) {
        if (this.id_utente == null) {
            _id_utente = id_utente;
        } else {
            this.id_utente.set(id_utente);
        }
    }*/
    @Access(AccessType.PROPERTY)
    public String getRitorno() {
        if (this.ritorno == null) {
            return _ritorno;
        } else {
            return ritorno.get();
        }
    }

    public void setRitorno(String ritorno) {
        if (this.ritorno == null) {
            _ritorno = ritorno;
        } else {
            this.ritorno.set(ritorno);
        }
    }

    public SimpleStringProperty agente() {

        if (agente == null) {
            agente = new SimpleStringProperty(this, "agente", _agente);
        }
        return (SimpleStringProperty) agente;
    }

    public SimpleStringProperty matricola() {

        if (matricola == null) {
            matricola = new SimpleStringProperty(this, "matricola", _matricola);
        }
        return (SimpleStringProperty) matricola;
    }

    public SimpleStringProperty ufficio() {

        if (ufficio == null) {
            ufficio = new SimpleStringProperty(this, "ufficio", _ufficio);
        }
        return (SimpleStringProperty) ufficio;
    }

    public SimpleStringProperty viaggioProperty() {

        if (viaggio == null) {
            viaggio = new SimpleStringProperty(this, "viaggio", _viaggio);
        }
        return (SimpleStringProperty) viaggio;
    }

    public SimpleStringProperty partenzaProperty() {

        if (partenza == null) {
            partenza = new SimpleStringProperty(this, "partenza", _partenza);
        }
        return (SimpleStringProperty) partenza;
    }

    public SimpleStringProperty ritornoProperty() {

        if (ritorno == null) {
            ritorno = new SimpleStringProperty(this, "ritorno", _ritorno);
        }
        return (SimpleStringProperty) ritorno;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

  

}

/*
    @Access(AccessType.PROPERTY)
    public Date getData_dal() {
        if (this.data_dal == null) {
            return _data_dal;
        } else {
            return data_dal.get();
        }
    }

    public void setData_dal(Object data_dal) {
        if (this.data_dal == null) {
            _data_dal = (Date) data_dal;
        } else {
            this.data_dal.set((Date) data_dal);
        }
    }

    @Access(AccessType.PROPERTY)
    public Date getData_al() {
        if (this.data_al == null) {
            return _data_al;
        } else {
            return (Date) data_al.get();
        }
    }

    public void setData_al(Object data_al) {
        if (this.data_al == null) {
            _data_al = (Date) data_al;
        } else {
            this.data_al.set(data_al);
        }
    }

    public SimpleIntegerProperty numeroProperty() {
        if (numero == null) {
            numero = new SimpleIntegerProperty(this, "numero", _numero);
        }
        return (SimpleIntegerProperty) numero;
    }

    public SimpleObjectProperty data_dalProperty() {
        if (data_dal == null) {
            data_dal = new SimpleObjectProperty(this, "data_dal", _data_dal);
        }
        return (SimpleObjectProperty) data_dal;
    }

    public SimpleObjectProperty data_alProperty() {
        if (data_al == null) {
            data_al = new SimpleObjectProperty(this, "data_al", _data_al);
        }
        return (SimpleObjectProperty) data_al;
    }
 */

 /*
    @Transient
    private int _numero = 1234;
    @Transient
    private IntegerProperty numero;

//non nullo
    @Transient
    private ObjectProperty<Date> data_dal;
    @Transient
    private Date _data_dal;

    @Transient
    private ObjectProperty data_al;
    @Transient
    private Date _data_al;
 */
 /*
    @Transient
     private double _totali;
     private DoubleProperty totali;

    @Transient
     private double _iva;
     private DoubleProperty iva;

    @Transient
     private double _spese_rappresentanza;
     private DoubleProperty spese_rappresentanza;

    @Transient
     private double _iva_spese_rappresentanza;
     private DoubleProperty iva_spese_rappresentanza;

    @Transient
     private double _rimborso_km;
     private DoubleProperty rimborso_km;


    @Transient
     private double _da_pagare;
     private DoubleProperty da_pagare;

    @Transient
     private double _costo_netto_trasferta;
     private DoubleProperty costo_netto_trasferta;

    @Transient
     private int _allegati;
     private IntegerProperty allegati;

    @Transient
     private String _firma;
     private StringProperty firma;

    @Transient
     private String _tipo_automezzo;
     private StringProperty tipo_automezzo;
    @Transient
     private int _km_previsti;
     private IntegerProperty km_previsti;

    @Transient
     private double _costo_km;
     private DoubleProperty costo_km;

    @Transient
     private ObjectProperty data_rimborso_km;
     private Date _data_rimborso_km;
    @Transient
     private double _totale_km;
     private DoubleProperty totale_km;

    @Transient
     private double _totale_rimborso_km;
     private DoubleProperty totale_rimborso_km;
 */
 /* public SimpleStringProperty id_utenteProperty() {

        if (id_utente == null) {
            id_utente = new SimpleStringProperty(this, "id_utente", _id_utente);
        }
        return (SimpleStringProperty) id_utente;
    }

       @Access(AccessType.PROPERTY)
    public int getAllegati() {
        if (this.allegati == null) {
            return _allegati;
        } else {
            return this.allegati.get();
        }
    }

    public void setAllegati(int allegati) {
        if (this.allegati == null) {
            _allegati = allegati;
        } else {
            this.allegati.set(allegati);
        }
    }

    @Access(AccessType.PROPERTY)
    public int getKm_previsti() {
        if (this.km_previsti == null) {
            return _km_previsti;
        } else {
            return this.km_previsti.get();
        }
    }

    public void setKm_previsti(int km_previsti) {
        if (this.km_previsti == null) {
            _km_previsti = km_previsti;
        } else {
            this.allegati.set(km_previsti);
        }
    }


    @Access(AccessType.PROPERTY)
    public double getCosto_km() {
        if (this.costo_km == null) {
            return _costo_km;
        } else {
            return this.costo_km.get();
        }
    }

    public void setCosto_km(double costo_km) {
        if (this.km_previsti == null) {
            _costo_km = costo_km;
        } else {
            this.costo_km.set(costo_km);
        }
    }


    @Access(AccessType.PROPERTY)
    public double getTotale_km() {
        if (this.totale_km == null) {
            return _totale_km;
        } else {
            return this.totale_km.get();
        }
    }

    public void setTotale_km(double totale_km) {
        if (this.totale_km == null) {
            _totale_km = totale_km;
        } else {
            this.totale_km.set(totale_km);
        }
    }





    @Access(AccessType.PROPERTY)
    public String getFirma() {
        if (this.firma == null) {
            return _firma;
        } else {
            return firma.get();
        }
    }

    public void setFirma(String firma) {
        if (this.firma == null) {
            _firma = firma;
        } else {
            this.firma.set(firma);
        }
    }

    @Access(AccessType.PROPERTY)
    public String getTipo_automezzo() {
        if (this.firma == null) {
            return _firma;
        } else {
            return firma.get();
        }
    }

    public void setTipo_automezzo(String tipo_automezzo) {
        if (this.tipo_automezzo == null) {
            _tipo_automezzo = tipo_automezzo;
        } else {
            this.tipo_automezzo.set(tipo_automezzo);
        }
    }



    @Access(AccessType.PROPERTY)
    @Lob
    public Object getData_rimborso_km() {
        if (this.data_rimborso_km == null) {
            return _data_rimborso_km;
        } else {
            return data_rimborso_km.get();
        }
    }

    public void setData_rimborso_km(Object data_rimborso_km) {
        if (this.data_rimborso_km == null) {
            _data_rimborso_km =(Date) data_rimborso_km;
        } else {
            this.data_rimborso_km.set(data_rimborso_km);
        }
    }

    @Access(AccessType.PROPERTY)
    @Lob
    public double getTotali() {
        if (this.totali == null) {
            return _totali;
        } else {
            return totali.get();
        }
    }

    public void setTotali(double totali) {
        if (this.totali == null) {
            _totali =(double) totali;
        } else {
            this.totali.set(totali);
        }
    }


    @Access(AccessType.PROPERTY)
    @Lob
    public double getIva() {
        if (this.iva == null) {
            return _iva;
        } else {
            return iva.get();
        }
    }

    public void setIva(double iva) {
        if (this.iva == null) {
            _iva = iva;
        } else {
            this.iva.set(iva);
        }
    }

    @Access(AccessType.PROPERTY)
    @Lob
    public double getSpese_rappresentanza() {
        if (this.spese_rappresentanza == null) {
            return _spese_rappresentanza;
        } else {
            return spese_rappresentanza.get();
        }
    }

    public void setSpese_rappresentanza(double spese_rappresentanza) {
        if (this.spese_rappresentanza == null) {
            _spese_rappresentanza = spese_rappresentanza;
        } else {
            this.spese_rappresentanza.set(spese_rappresentanza);
        }
    }

    @Access(AccessType.PROPERTY)
    @Lob
    public double getIva_spese_rappresentanza() {
        if (this.iva_spese_rappresentanza == null) {
            return _iva_spese_rappresentanza;
        } else {
            return iva_spese_rappresentanza.get();
        }
    }

    public void setIva_spese_rappresentanza(double iva_spese_rappresentanza) {
        if (this.iva_spese_rappresentanza == null) {
            _iva_spese_rappresentanza =iva_spese_rappresentanza;
        } else {
            this.iva_spese_rappresentanza.set(iva_spese_rappresentanza);
        }
    }


    @Access(AccessType.PROPERTY)
    @Lob
    public double getRimborso_km() {
        if (this.rimborso_km == null) {
            return _rimborso_km;
        } else {
            return rimborso_km.get();
        }
    }

    public void setRimborso_km(double rimborso_km) {
        if (this.rimborso_km == null) {
            _rimborso_km = rimborso_km;
        } else {
            this.rimborso_km.set(rimborso_km);
        }
    }


    @Access(AccessType.PROPERTY)
    @Lob
    public double getTotale_rimborso_km() {
        if (this.totale_rimborso_km == null) {
            return _totale_rimborso_km;
        } else {
            return totale_rimborso_km.get();
        }
    }

    public void setTotale_rimborso_km(double totale_rimborso_km) {
        if (this.totale_rimborso_km == null) {
            _totale_rimborso_km = totale_rimborso_km;
        } else {
            this.totale_rimborso_km.set(totale_rimborso_km);
        }
    }






    @Access(AccessType.PROPERTY)
    @Lob
    public double getDa_pagare() {
        if (this.da_pagare == null) {
            return _da_pagare;
        } else {
            return da_pagare.get();
        }
    }

    public void setDa_pagare(double da_pagare) {
        if (this.rimborso_km == null) {
            _da_pagare = da_pagare;
        } else {
            this.da_pagare.set(da_pagare);
        }
    }

    @Access(AccessType.PROPERTY)
    @Lob
    public double getCosto_netto_trasferta() {
        if (this.costo_netto_trasferta == null) {
            return _costo_netto_trasferta;
        } else {
            return costo_netto_trasferta.get();
        }
    }

    public void setCosto_netto_trasferta(double costo_netto_trasferta) {
        if (this.costo_netto_trasferta == null) {
            _costo_netto_trasferta = costo_netto_trasferta;
        } else {
            this.costo_netto_trasferta.set(costo_netto_trasferta);
        }
    }






   public SimpleIntegerProperty km_previstiProperty() {
        if (km_previsti == null) {
            km_previsti = new SimpleIntegerProperty(this, "km_previsti", _km_previsti);
        }
        return (SimpleIntegerProperty) km_previsti;
    }


    public SimpleIntegerProperty allegatiProperty() {
        if (allegati == null) {
            allegati = new SimpleIntegerProperty(this, "allegati", _allegati);
        }
        return (SimpleIntegerProperty) allegati;
    }









    public SimpleObjectProperty data_rimborso_kmProperty() {
        if (data_rimborso_km == null) {
            data_rimborso_km = new SimpleObjectProperty(this, "data_rimborso_km", _data_rimborso_km);
        }
        return (SimpleObjectProperty) data_rimborso_km;
    }




   public SimpleStringProperty firmaProperty() {

        if (firma == null) {
            firma = new SimpleStringProperty(this, "firma", _firma);
        }
        return (SimpleStringProperty) firma;
    }



    public SimpleStringProperty tipo_automezzoProperty() {

        if (tipo_automezzo == null) {
            tipo_automezzo = new SimpleStringProperty(this, "tipo_automezzo", _tipo_automezzo);
        }
        return (SimpleStringProperty) tipo_automezzo;
    }



    public SimpleDoubleProperty totaliProperty() {
        if (totali == null) {
            totali = new SimpleDoubleProperty(this, "totali", _totali);
        }
        return (SimpleDoubleProperty) totali;
    }


    public SimpleDoubleProperty ivaProperty() {
        if (iva == null) {
            iva = new SimpleDoubleProperty(this, "iva", _iva);
        }
        return (SimpleDoubleProperty) iva;
    }



    public SimpleDoubleProperty spese_rappresentanzaProperty() {
        if (spese_rappresentanza == null) {
            spese_rappresentanza = new SimpleDoubleProperty(this, "spese_rappresentanza", _spese_rappresentanza);
        }
        return (SimpleDoubleProperty) spese_rappresentanza;
    }

    public SimpleDoubleProperty iva_spese_rappresentanzaProperty() {
        if (iva_spese_rappresentanza == null) {
            iva_spese_rappresentanza = new SimpleDoubleProperty(this, "iva_spese_rappresentanzaProperty", _iva_spese_rappresentanza);
        }
        return (SimpleDoubleProperty) iva_spese_rappresentanza;
    }



    public SimpleDoubleProperty rimborso_kmProperty() {
        if (rimborso_km == null) {
            rimborso_km = new SimpleDoubleProperty(this, "rimborso_km", _rimborso_km);
        }
        return (SimpleDoubleProperty) rimborso_km;
    }




    public SimpleDoubleProperty da_pagareProperty() {
        if (da_pagare == null) {
            da_pagare = new SimpleDoubleProperty(this, "da_pagare", _da_pagare);
        }
        return (SimpleDoubleProperty) da_pagare;
    }


    public SimpleDoubleProperty costo_netto_trasfertaProperty() {
        if (costo_netto_trasferta == null) {
            costo_netto_trasferta = new SimpleDoubleProperty(this, "costo_netto_trasferta", _costo_netto_trasferta);
        }
        return (SimpleDoubleProperty) costo_netto_trasferta;
    }

    public SimpleDoubleProperty totale_rimborso_kmProperty() {
        if (totale_rimborso_km == null) {
            totale_rimborso_km = new SimpleDoubleProperty(this, "totale_rimborso_km", _totale_rimborso_km);
        }
        return (SimpleDoubleProperty) totale_rimborso_km;
    }




    public SimpleDoubleProperty costo_kmProperty() {
        if (costo_km == null) {
            costo_km = new SimpleDoubleProperty(this, "costo_km", _costo_km);
        }
        return (SimpleDoubleProperty) costo_km;
    }

    public SimpleDoubleProperty totale_kmProperty() {
        if (totale_km == null) {
            totale_km = new SimpleDoubleProperty(this, "totale_km", _totale_km);
        }
        return (SimpleDoubleProperty) totale_km;
    }
 */
 /*
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
 */
 /*
    @Access(AccessType.PROPERTY)
    @Column(nullable = false)
    public int getNumero() {
        if (this.numero == null) {
            return _numero;
        } else {
            return this.numero.get();
        }
    }

    public void setNumero(int numero) {
        if (this.numero == null) {
            _numero = numero;
        } else {
            this.numero.set(numero);
        }
    }*/
