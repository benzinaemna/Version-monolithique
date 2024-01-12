package com.miniProjet.controllers;

import com.miniProjet.dto.ClientDto;
import com.miniProjet.dto.FournisseurDto;
import com.miniProjet.services.TierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/fournisseur")
public class FournisseurController {
    private TierService tierService;
    @Autowired
    public FournisseurController(TierService tierService ){
        this.tierService=tierService;
    }
    @GetMapping("/list")
    public String ListFournisseur(Model theModel){
        List<FournisseurDto> fournisseurs = tierService.ListFournisseur();
        theModel.addAttribute("fournisseur", fournisseurs);
        return "List-Fournisseur";
    }
    @GetMapping("/FormForAdd")
    public String AddFournisseur(Model theModel){
        FournisseurDto fournisseur = new FournisseurDto();
        theModel.addAttribute("fournisseur" , fournisseur);
        return "/Fournisseur-form";
    }
    @GetMapping("/FormForUpdate")
    public String UpdateFournisseur(@RequestParam("id") UUID Id , Model theModel){
        FournisseurDto fournisseur = tierService.findFournisseurById(Id);
        theModel.addAttribute("fournisseur" , fournisseur);
        return "/Fournisseur-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("fournisseur") FournisseurDto fournisseurDto){
        tierService.CreateFournisseur(fournisseurDto);
        return "redirect:/fournisseur/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID theId){
        tierService.deleteFournisseur(theId);
        return "redirect:/fournisseur/list";
    }
}
