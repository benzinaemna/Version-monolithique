package com.miniProjet.services;

import com.miniProjet.model.Categorie;
import com.miniProjet.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategorieServiceImpl implements CategorieService{

    private CategorieRepository categorieRepository;

    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository){

        this.categorieRepository = categorieRepository;
    }
    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();

    }

    @Override
    public Optional<Categorie> getGategorieById(UUID Id) {

        return categorieRepository.findById(Id);
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
        return categorie;
    }
    @Override
    public void deleteCategorie(UUID id) {
        categorieRepository.deleteById(id);
    }
}
