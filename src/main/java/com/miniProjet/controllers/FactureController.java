package com.miniProjet.controllers;

import com.miniProjet.dto.ClientDto;
import com.miniProjet.model.Client;
import com.miniProjet.model.Facture;
import com.miniProjet.model.LigneFacture;
import com.miniProjet.services.DocumentService;
import com.miniProjet.services.LigneDocumentService;
import com.miniProjet.services.ProduitService;
import com.miniProjet.services.TierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/facture")
public class FactureController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private LigneDocumentService ligneDocumentService;
    @Autowired
    private TierService tierService;
    @Autowired
    private ProduitService produitService;
    List<LigneFacture> ligneFactures =new ArrayList<>();
    double total = 0;
    @GetMapping("/list")
    public String ListFacture(Model theModel){
       List<Facture> factures= documentService.findAll();
        theModel.addAttribute("factures" , factures);
        return "List-Facture";
    }
    @GetMapping("/FormForAdd")
    public String AddFacture(Model themodel, Facture facture , LigneFacture ligneFacture){
        Facture facture1 = new Facture();
        LigneFacture ligneFacture1 = new LigneFacture();
        List<ClientDto> clients = tierService.ListClient();
        themodel.addAttribute("facture" , facture1);
        themodel.addAttribute("ligneFactures" , ligneFactures);
        themodel.addAttribute("ligneFacture" , ligneFacture1);
        themodel.addAttribute("clients" , clients);
        themodel.addAttribute("produits" , produitService.findAll());
        return "/Facture-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("facture") Facture facture){
        System.out.println("hhhhh"+total);
        facture.setTotal(total);
        System.out.println( facture.getTotal());

        documentService.createFacture(facture);
       for (LigneFacture ligne : ligneFactures) {
            ligne.setFacture(facture);
            ligneDocumentService.create(ligne);
        }
       facture.setTotal(total);
       ligneFactures =new ArrayList<>();
       total = 0;
        return "redirect:/facture/list";
    }
    @PostMapping("/saveLigne")
    public String saveLigne(Model themodel , @ModelAttribute("ligneFacture")LigneFacture ligneFacture){
        ligneFacture.setPrix(ligneFacture.getQuantity() * ligneFacture.getProduit().getPrixVente());
        total= total + ligneFacture.getPrix();
        ligneFactures.add(ligneFacture);
        themodel.addAttribute("ligneFactures" , ligneFactures);
        return "redirect:/facture/FormForAdd";
    }

    @GetMapping("/FormForUpdate")
    public String edit(@RequestParam("id") UUID Id, @ModelAttribute("facture") Facture facture , Model theModel){
        Optional<Facture> facture1 = documentService.getFactureById(Id);
        LigneFacture ligneFacture3 = new LigneFacture();
        List<LigneFacture> ligneFacture1 = ligneDocumentService.findByFactureId(Id);
        theModel.addAttribute("ligneFactures" , ligneFactures);
        theModel.addAttribute("ligneFacture" , ligneFacture1);
        theModel.addAttribute("ligneFacture3" , ligneFacture3);
        theModel.addAttribute("produits" , produitService.findAll());
        theModel.addAttribute("clients" , tierService.ListClient());
        theModel.addAttribute("facture" , facture1);
        return"/Update-Facture";
    }
    @PostMapping("/UpdateLigne")
    public String UpdateLigne(Model themodel , @ModelAttribute("ligneFacture")LigneFacture ligneFacture , @RequestParam("id") UUID Id){
        List<LigneFacture> ligneFactures = ligneDocumentService.findByFactureId(Id);
        ligneFactures.add(ligneFacture);
        themodel.addAttribute("ligneFacture" , ligneFactures);
        return "redirect:/facture/Update-Facture";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID theId){
       documentService.deleteFacture(theId);
        return "redirect:/facture/list";
    }
}
