package com.miniProjet.services;

import com.miniProjet.model.Document;
import com.miniProjet.model.Facture;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentService {
    List<Facture> findAll();
    Optional<Facture> getFactureById(UUID Id);
    Facture createFacture(Facture document);
    void deleteFacture(UUID id);
}
