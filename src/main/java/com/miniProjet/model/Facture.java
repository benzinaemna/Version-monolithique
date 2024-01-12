package com.miniProjet.model;


import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@DiscriminatorValue("Facture")
public class Facture extends Document{

    @ManyToOne
    private Client client;
    private double total;
    @OneToMany(mappedBy = "facture" , cascade = CascadeType.ALL)
    private Collection<LigneFacture> ligneFacture;
    public Facture() {
    }

    public Facture(UUID id, Date dateFacture, String Code, Client client, double total) {
        super(id, dateFacture, Code);
        this.client = client;
        this.total = total;
    }

    public Tier getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Collection<LigneFacture> getLigneFacture() {
        return ligneFacture;
    }

    public void setLigneFacture(Collection<LigneFacture> ligneFacture) {
        this.ligneFacture = ligneFacture;
    }


}
