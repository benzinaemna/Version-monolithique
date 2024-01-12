package com.miniProjet.services;

import com.miniProjet.model.Categorie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategorieService {
    List<Categorie> findAll();
    Optional<Categorie> getGategorieById(UUID Id);
    Categorie createCategorie(Categorie categorie);
    void deleteCategorie(UUID id);
}
