package com.miniProjet.services;


import com.miniProjet.model.LigneFacture;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LigneDocumentService {
    List<LigneFacture> findAll();
    Optional<LigneFacture> getFactureById(UUID Id);
    LigneFacture create(LigneFacture produit);
    List<LigneFacture> findByFactureId(UUID factureId);
    void delete(UUID id);
}
