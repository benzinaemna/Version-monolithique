package com.miniProjet.repositories;

import com.miniProjet.model.LigneDocument;
import com.miniProjet.model.LigneFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface LigneFactureRepository extends JpaRepository<LigneFacture, UUID> {
    List<LigneFacture> findByFactureId(UUID factureId);
}
