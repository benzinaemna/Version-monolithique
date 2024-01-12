package com.miniProjet.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Collection;
import java.util.UUID;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;
    @NotNull
    @Column(length = 50)
    private String designation;
    private String code;
    private double prixAchat;
    private double prixVente;
    @ManyToOne
    private Categorie categorie;
    @OneToMany(mappedBy = "produit")
    private Collection<LigneFacture> ligneFacture;

    public Produit() {
    }

    public Produit(UUID id, String designation, String code, double prixAchat, double prixVente, Categorie categorie) {
        this.id = id;
        this.designation = designation;
        this.code = code;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.categorie = categorie;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
