package com.miniProjet.controllers;

import com.miniProjet.dto.ClientDto;
import com.miniProjet.model.Client;
import com.miniProjet.services.TierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
@RequestMapping(value = "/client")
public class ClientController {

    private TierService tierService;
    @Autowired
  public ClientController(TierService tierService ){
      this.tierService=tierService;
  }
    @GetMapping("/list")
    public String ListClient(Model theModel){
      List<ClientDto> clients = tierService.ListClient();
        theModel.addAttribute("clients", clients);
        return "List-Client";
    }
    @GetMapping("/FormForAdd")
    public String AddClient(Model theModel){
        ClientDto client = new ClientDto();
        theModel.addAttribute("client" , client);
        return "/Client-form";
    }
    @GetMapping("/FormForUpdate")
    public String UpdateClient(@RequestParam("id") UUID Id , Model theModel){
        ClientDto client = tierService.findClientById(Id);
        theModel.addAttribute("client" , client);
        return "/Client-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("client") ClientDto client){
        tierService.CreateClient(client);
        return "redirect:/client/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID theId){
        tierService.deleteClient(theId);
        return "redirect:/client/list";
    }
}
