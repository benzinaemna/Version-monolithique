package com.miniProjet.controllers;

import com.miniProjet.dto.ClientDto;
import com.miniProjet.model.Categorie;
import com.miniProjet.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "categorie")
public class CategorieController {

    private CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService){

        this.categorieService = categorieService;
    }
    @GetMapping("/list")
    public String ListCategorie(Model model){
        List<Categorie> categories = categorieService.findAll();
        model.addAttribute("categories", categories );
        return "List-Categorie";
    }
    @GetMapping("/FormForAdd")
    public String AddCategorie(Model theModel){
        Categorie categorie = new Categorie();
        theModel.addAttribute("categorie" , categorie);
        return "/Categorie-form";
    }
    @GetMapping("/FormForUpdate")
    public String UpdateCategorie(@RequestParam("id") UUID Id , Model theModel){
        Optional<Categorie> categorie = categorieService.getGategorieById(Id);
        theModel.addAttribute("categorie" , categorie);
        return "/Categorie-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("categorie") Categorie categorie){
        categorieService.createCategorie(categorie);
        return "redirect:/categorie/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID theId){
        categorieService.deleteCategorie(theId);
        return "redirect:/categorie/list";
    }
}
