package com.miniProjet.repositories;

import com.miniProjet.model.Client;
import com.miniProjet.model.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    @Override
    Optional<Client> findById(UUID uuid);
}
