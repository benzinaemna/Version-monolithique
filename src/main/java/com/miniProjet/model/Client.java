package com.miniProjet.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Collection;
import java.util.UUID;

@Entity
@DiscriminatorValue("Client")
public class Client extends Tier{
    @OneToMany(mappedBy = "client")
    private Collection<Facture> Documents;

    public Client() {
    }

    public Client(UUID id, String firstName, String lastName, String email, String numTel, String adresse, String mf, String cin) {
        super(id, firstName, lastName, email, numTel, adresse, mf, cin);
    }
}
