package com.miniProjet.services;

import com.miniProjet.model.Document;
import com.miniProjet.model.Facture;
import com.miniProjet.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {
    private FactureRepository factureRepository;
    @Autowired
    public DocumentServiceImpl(FactureRepository factureRepository){

        this.factureRepository = factureRepository;
    }
    @Override
    public List<Facture> findAll() {

        return factureRepository.findAll();
    }

    @Override
    public Optional<Facture> getFactureById(UUID Id) {
        return factureRepository.findById(Id);
    }

    @Override
    public Facture createFacture(Facture document) {

        return factureRepository.save(document);
    }

    @Override
    public void deleteFacture(UUID id) {
        factureRepository.deleteById(id);
    }
}
