package com.miniProjet.services;


import com.miniProjet.dto.ClientDto;
import com.miniProjet.dto.FournisseurDto;
import com.miniProjet.model.Client;
import com.miniProjet.model.Fournisseur;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TierService {
    List<ClientDto> ListClient();
   ClientDto findClientById(UUID Id);
    ClientDto CreateClient(ClientDto clientDto);
    void deleteClient(UUID Id);
    List<FournisseurDto> ListFournisseur();
    FournisseurDto findFournisseurById(UUID Id);
    FournisseurDto CreateFournisseur(FournisseurDto fournisseurDto);
    void deleteFournisseur(UUID Id);

}
