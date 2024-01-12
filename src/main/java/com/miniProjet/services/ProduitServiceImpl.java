package com.miniProjet.services;

import com.miniProjet.model.Categorie;
import com.miniProjet.model.Produit;
import com.miniProjet.repositories.CategorieRepository;
import com.miniProjet.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProduitServiceImpl implements ProduitService{

    private ProduitRepository produitRepository;

    @Autowired
    public ProduitServiceImpl( ProduitRepository produitRepository){

        this.produitRepository = produitRepository;
    }
    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();

    }

    @Override
    public Optional<Produit> getProduitById(UUID Id) {

        return produitRepository.findById(Id);
    }

    @Override
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(UUID id) {
        produitRepository.deleteById(id);
    }
}
