package com.miniProjet.services;

import com.miniProjet.model.Categorie;
import com.miniProjet.model.Produit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProduitService {
    List<Produit> findAll();
    Optional<Produit> getProduitById(UUID Id);
    Produit createProduit(Produit produit);
    void deleteProduit(UUID id);
}
