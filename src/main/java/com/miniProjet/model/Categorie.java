package com.miniProjet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String code;
    private String designation;
    @OneToMany(mappedBy = "categorie")
    private Collection<Produit> produits = new ArrayList<Produit>();

    public Categorie() {
    }

    public Categorie(UUID id, String code, String designation) {
        this.id = id;
        this.code = code;
        this.designation = designation;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
