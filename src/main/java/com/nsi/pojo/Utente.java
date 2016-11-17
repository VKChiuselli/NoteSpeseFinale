package com.nsi.pojo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.hibernate.annotations.GenericGenerator;




import javax.persistence.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by acerioni on 07/09/2016.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "Utenti")
public class Utente implements Externalizable {


@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2") //16 char
@Column(name = "uuid", unique = true)
private String id;
private  StringProperty cognome;
@Transient
private String _cognome;
private StringProperty nome;
@Transient
private String _nome;
private StringProperty matricola;
@Transient
private String _matricola;
private StringProperty ufficio;
@Transient
private String _ufficio;



public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

@Access(AccessType.PROPERTY)
public String getCognome() {
    if (this.cognome == null) {
        return _cognome;
    } else {
        return this.cognome.get();
    }
}

public void setCognome(String cognome) {
    if (this.cognome == null) {
        _cognome = cognome;
    } else {
        this.cognome.set(cognome);
    }
}

@Access(AccessType.PROPERTY)
public String getNome() {
    if (this.nome == null) {
        return _nome;
    } else {
        return nome.get();
    }
}

public void setNome(String nome) {
    if (this.nome == null) {
        _nome = nome;
    } else {
        this.nome.set(nome);
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

public void setUfficio(String ufficio) {
    if (this.ufficio == null) {
        _ufficio = ufficio;
    } else {
        this.ufficio.set(ufficio);
    }
}

/*Esposizione delle proprietà per JFX*/
public SimpleStringProperty cognomeProperty() {
    if (cognome == null) {
        cognome = new SimpleStringProperty(this, "cognome", _cognome);
    }
    return (SimpleStringProperty) cognome;
}

public SimpleStringProperty nomeProperty() {

    if (nome == null) {
        nome = new SimpleStringProperty(this, "nome", _nome);
    }
    return (SimpleStringProperty) nome;
}

public SimpleStringProperty matricolaProperty() {
    if (matricola == null) {
        matricola = new SimpleStringProperty(this, "matricola", _matricola);
    }
    return (SimpleStringProperty) matricola;
}

public SimpleStringProperty ufficioProperty() {
    if (ufficio == null) {
        ufficio = new SimpleStringProperty(this, "ufficio", _ufficio);
    }
    return (SimpleStringProperty) ufficio;
}
/*FINE Esposizione delle proprietà per JFX*/


/*Questo oggetto è serializzabile*/
@Override
public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(getId());
    out.writeObject(getCognome());
    out.writeObject(getNome());
    out.writeObject(getMatricola());
    out.writeObject(getUfficio());
}

@Override
public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    setId((String) in.readObject());
    setCognome((String) in.readObject());
    setNome((String) in.readObject());
    setMatricola((String) in.readObject());
    setUfficio((String) in.readObject());
}

}
