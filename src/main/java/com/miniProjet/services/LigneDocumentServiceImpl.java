package com.miniProjet.services;

import com.miniProjet.model.LigneDocument;
import com.miniProjet.model.LigneFacture;
import com.miniProjet.repositories.LigneFactureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LigneDocumentServiceImpl implements LigneDocumentService{

    private LigneFactureRepository ligneFactureRepository;

    public LigneDocumentServiceImpl(LigneFactureRepository ligneFactureRepository){

        this.ligneFactureRepository = ligneFactureRepository;
    }
    @Override
    public List<LigneFacture> findAll() {
        return ligneFactureRepository.findAll();

    }

    @Override
    public Optional<LigneFacture> getFactureById(UUID Id) {
        return ligneFactureRepository.findById(Id);
    }

    @Override
    public LigneFacture create(LigneFacture ligneFacture) {
        return ligneFactureRepository.save(ligneFacture);
    }

    @Override
    public List<LigneFacture> findByFactureId(UUID factureId) {
        return ligneFactureRepository.findByFactureId(factureId);
    }

    @Override
    public void delete(UUID id) {
        ligneFactureRepository.deleteById(id);

    }
}
