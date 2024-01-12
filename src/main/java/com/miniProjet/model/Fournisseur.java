package com.miniProjet.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Fournisseur")
public class Fournisseur extends Tier{
}
