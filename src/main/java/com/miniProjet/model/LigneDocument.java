package com.miniProjet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

import static jakarta.persistence.InheritanceType.SINGLE_TABLE;

@Data
@Entity
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,
        name = "TypeLigneDocument")
public class LigneDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private double quantity;
    private double prix;
    @ManyToOne
    private Produit produit;


    public LigneDocument(UUID id, double quantity, double prix, Produit produit) {
        this.id = id;
        this.quantity = quantity;
        this.prix = prix;
        this.produit = produit;

    }

    public LigneDocument() {
    }



    public LigneDocument(Long quantity, double prix, Produit produit) {
        this.quantity = quantity;
        this.prix = prix;
        this.produit = produit;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {

        this.prix = prix;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
