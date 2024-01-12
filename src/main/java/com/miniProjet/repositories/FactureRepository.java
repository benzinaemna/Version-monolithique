package com.miniProjet.repositories;

import com.miniProjet.model.Document;
import com.miniProjet.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FactureRepository extends JpaRepository<Facture, UUID> {
}
