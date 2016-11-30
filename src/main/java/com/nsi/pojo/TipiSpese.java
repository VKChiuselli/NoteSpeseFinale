package com.nsi.pojo;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by v.chiuselli on 24/11/2016.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "TipiSpese")
public class TipiSpese implements Externalizable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "uuid", unique = true)
    private String id;

    private final StringProperty descrizione = new SimpleStringProperty();
    private final StringProperty importo = new SimpleStringProperty();
    private final StringProperty iva = new SimpleStringProperty();

  /*  @OneToMany(fetch = FetchType.LAZY, mappedBy = "noteSpese")
    private Set<NoteSpese> noteSpese = new HashSet<NoteSpese>(0);
    
    
    public Set<NoteSpese> getNoteSpese() {
        return noteSpese;
    }

    public void setNoteSpese(Set<NoteSpese> noteSpese) {
        this.noteSpese = noteSpese;
    }
*/
    
    
    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Access(AccessType.PROPERTY)
    public String getDescrizione() {
        return descrizione.get();
    }

    public void setDescrizione(String descrizione) {
        this.descrizione.set(descrizione);
    }

    @Access(AccessType.PROPERTY)
    public String getImporto() {
        return importo.get();
    }

    public void setImporto(String importo) {
        this.importo.set(importo);
    }

    @Access(AccessType.PROPERTY)
    public String getIva() {
        return iva.get();
    }

    public void setIva(String iva) {
        this.iva.set(iva);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
