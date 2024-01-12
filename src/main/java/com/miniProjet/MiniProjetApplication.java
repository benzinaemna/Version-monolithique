package com.miniProjet;

import com.miniProjet.dto.ClientDto;
import com.miniProjet.dto.FournisseurDto;
import com.miniProjet.model.*;
import com.miniProjet.repositories.LigneFactureRepository;
import com.miniProjet.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MiniProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjetApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(TierService tierService ,
									  CategorieService categorieService,
									  ProduitService produitService ,
									  DocumentService documentService,
									  LigneDocumentService ligneDocumentService) {
		return args -> {
			ClientDto client = new ClientDto(null , "emna", "ben zina", "25756063", "11086196", "emnabenzina8@gmail.com", "route tunis ", null, null);
			System.out.println("code"+client.getId());
			FournisseurDto fournisseur = new FournisseurDto(null , "karim", "ben zina", "25756063", "11086196", "emnabenzina8@gmail.com", "route tunis ", null, null);
			Categorie categorie = new Categorie(null, "cat1" , "categoerie1" );
			Categorie categorie1 = new Categorie(null, "cat2" , "categoerie2" );
			Categorie categorie2 = new Categorie(null, "cat3" , "categoerie3" );
			categorieService.createCategorie(categorie);
			categorieService.createCategorie(categorie1);
			categorieService.createCategorie(categorie2);
			tierService.CreateClient(client);
			List<ClientDto> clients = tierService.ListClient();
			for (ClientDto client1 : clients
				 ) {

				System.out.println(client1);
			}

			System.out.println("code"+client.getId());
			tierService.CreateFournisseur(fournisseur);
			Produit produit = new Produit(null, "prod222" , "produit1" , 100, 500,categorie);
			Produit produit2 = new Produit(null, "prod" , "produit2" , 100, 5550,categorie2);
			produitService.createProduit(produit);
			produitService.createProduit(produit2);
			/*Client client1 = new Client(null , "gggg" , "bbb" , "rtyui" , "ertyhjk" , "sdfgh" , "erty" , "dfghj");
			Facture facture = documentService.createFacture(new Facture(null , new Date() , null , client1 , client.getId(), "f-12"));
			/*List<Produit> listeProduits = produitService.findAll();
			listeProduits.forEach(produit1 -> {
				LigneFacture ligneFacture = new LigneFacture();
				ligneFacture.setProductId(produit1.getId());
				ligneFacture.setPrix(produit1.getPrixVente());
				ligneFacture.setQuantity(50.5);
				ligneFacture.setFacture(facture);
				ligneFactureRepository.create(ligneFacture);
			});*/
			/*LigneFacture ligneFacture = new LigneFacture(null , produit.getId(), produit.getPrixVente(), 50, produit, facture);
			LigneFacture ligneFacture2 = new LigneFacture(null , produit2.getId(), produit2.getPrixVente(), 50, produit2, facture);

			ligneDocumentService.create(ligneFacture);
			ligneDocumentService.create(ligneFacture2);*/
		};
	}

}
