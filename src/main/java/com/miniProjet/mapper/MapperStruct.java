package com.miniProjet.mapper;

import com.miniProjet.dto.ClientDto;
import com.miniProjet.dto.FournisseurDto;
import com.miniProjet.model.Client;
import com.miniProjet.model.Fournisseur;
import com.miniProjet.model.Tier;
import org.mapstruct.*;


@Mapper(
        componentModel = "spring"
)
public interface MapperStruct {

    ClientDto clienttoClientDto(Client client);
    FournisseurDto fournisseurtoFournisseurDto(Fournisseur fournisseur);
    Client clientDtotoClient(ClientDto clientDto);
    Fournisseur fournisseurDtotoFournisseur(FournisseurDto fournisseurDto);


}
