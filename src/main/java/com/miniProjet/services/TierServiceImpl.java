package com.miniProjet.services;

import com.miniProjet.dto.ClientDto;
import com.miniProjet.dto.FournisseurDto;
import com.miniProjet.mapper.MapperStruct;
import com.miniProjet.model.Client;
import com.miniProjet.model.Fournisseur;
import com.miniProjet.repositories.ClientRepository;
import com.miniProjet.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TierServiceImpl implements TierService {

    private ClientRepository clientRepository;
    private FournisseurRepository fournisseurRepository;
    private MapperStruct mapperStruct;
    @Autowired
    public TierServiceImpl(MapperStruct mapperStruct , ClientRepository clientRepository, FournisseurRepository fournisseurRepository){
        this.mapperStruct= mapperStruct;
        this.clientRepository=clientRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public List<ClientDto> ListClient() {
      List<Client> tiers= clientRepository.findAll();
      List<ClientDto> clientDtos =new ArrayList<>();
      for(Client client : tiers){
          clientDtos.add(mapperStruct.clienttoClientDto(client));
      }
        return clientDtos;
    }

    @Override
    public ClientDto findClientById(UUID id) {
        Client client = clientRepository.findById(id).orElse(null);
        if(client == null){
            return null;
        }
        return mapperStruct.clienttoClientDto(client);
    }

    @Override
    public ClientDto CreateClient(ClientDto clientDto) {
        clientRepository.save(mapperStruct.clientDtotoClient(clientDto));
       return clientDto;
    }

    @Override
    public void deleteClient(UUID Id) {
        clientRepository.deleteById(Id);
    }

    @Override
    public List<FournisseurDto> ListFournisseur() {
        List<Fournisseur> tiers= fournisseurRepository.findAll();
        List<FournisseurDto> fournisseurDtos =new ArrayList<>();
        for(Fournisseur fournisseur : tiers){
            fournisseurDtos.add(mapperStruct.fournisseurtoFournisseurDto(fournisseur));
        }
        return fournisseurDtos;
    }

    @Override
    public FournisseurDto findFournisseurById(UUID id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id).orElse(null);
        if(fournisseur == null){
            return null;
        }
        return mapperStruct.fournisseurtoFournisseurDto(fournisseur);
    }

    @Override
    public FournisseurDto CreateFournisseur(FournisseurDto fournisseurDto) {
        fournisseurRepository.save(mapperStruct.fournisseurDtotoFournisseur(fournisseurDto));
        return fournisseurDto;
    }

    @Override
    public void deleteFournisseur(UUID Id) {
        fournisseurRepository.deleteById(Id);
    }
}
