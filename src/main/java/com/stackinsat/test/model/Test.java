package com.stackinsat.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="test")
public class Test {

    @Id
    @Column(name="id")
    Long id;

    @Column(name="libelle")
    String libelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibele(String libelle) {
        this.libelle = libelle;
    }


}
