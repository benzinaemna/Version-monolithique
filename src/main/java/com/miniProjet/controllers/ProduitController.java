package com.miniProjet.controllers;

import com.miniProjet.model.Categorie;
import com.miniProjet.model.Produit;
import com.miniProjet.services.CategorieService;
import com.miniProjet.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/produit")
public class ProduitController {
    private ProduitService produitService;
    private CategorieService categorieService;

    @Autowired
    public ProduitController(ProduitService produitService , CategorieService CategorieService){

        this.produitService = produitService;
        this.categorieService = CategorieService;
    }
    @GetMapping("/list")
    public String ListCategorie(Model model){
        List<Produit> produits = produitService.findAll();
        model.addAttribute("produits", produits );
        return "List-Produit";
    }
    @GetMapping("/FormForAdd")
    public String AddCategorie(Model theModel){
        Produit produit = new Produit();
        List<Categorie> categories = categorieService.findAll();
        theModel.addAttribute("produit" , produit);
        theModel.addAttribute("categories" , categories);
        return "/Produit-form";
    }
    @GetMapping("/FormForUpdate")
    public String UpdateProduit(@RequestParam("id") UUID Id , Model theModel){
        Optional<Produit> produit = produitService.getProduitById(Id);
        List<Categorie> categories = categorieService.findAll();
        theModel.addAttribute("categories" , categories);
        theModel.addAttribute("produit" , produit);
        return "/Produit-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("produit") Produit produit){
        produitService.createProduit(produit);
        return "redirect:/produit/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID theId){
        produitService.deleteProduit(theId);
        return "redirect:/produit/list";
    }
}
