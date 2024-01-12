package com.miniProjet.repositories;


import com.miniProjet.model.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TierRepository extends JpaRepository<Tier, UUID> {
  //  List<Tier> findByTypeTier(String typeTier);
}
