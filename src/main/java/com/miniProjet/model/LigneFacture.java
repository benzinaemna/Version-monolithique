package com.miniProjet.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
@DiscriminatorValue("LigneFacture")
public class LigneFacture extends LigneDocument{
    @ManyToOne
    private Facture facture;
    public LigneFacture() {
    }

    public LigneFacture(UUID id, double quantity, double prix, Produit produit) {
        super(id, quantity, prix, produit);
    }

    public LigneFacture(UUID id, double quantity, double prix, Produit produit, Facture facture) {
        super(id, quantity, prix, produit);
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
