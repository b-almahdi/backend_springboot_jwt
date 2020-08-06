package com.nextgeneration.commandeProduit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.commande.CommandeRepository;
import com.nextgeneration.produit.Produit;
import com.nextgeneration.produit.ProduitRepository;

@Service
public class ProduitCommandeService {
	
	@Autowired
    private ProduitRepository produitRepository;
	@Autowired 
	private CommandeRepository commandeRepository;

	CommandeProduit commandeProduit;
	Produit produit;
	List<CommandeProduit> commandeProduits = new ArrayList<>();
	List<Produit> produits = new ArrayList<>();
 	
	public Optional<Object> addProduitToCommande(CommandeProduitDTO commandeProduitDTO) {
		
		return commandeRepository.findById(commandeProduitDTO.getIdCommande()).map(commande -> {
			
			for(ProduitQuantiteDTO produitQuantiteDTO: commandeProduitDTO.getProduits()) {
				produit = produitRepository.findById(produitQuantiteDTO.getProduitId()).get();
				if(produit.getQuantite()<produitQuantiteDTO.getQuantite()) {
					throw new Error("Out of stock");
				}
				
				commandeProduit = new CommandeProduit();
				commandeProduit.setProduit(produit);
				commandeProduit.setQuantite(produitQuantiteDTO.getQuantite());
				commandeProduits.add(commandeProduit);
				
	            produit.setQuantite(produit.getQuantite()-produitQuantiteDTO.getQuantite());
				produits.add(produit);
			}
//			commandeProduit.setProduit(produit);
//			commandeProduit.setQuantite(commandeProduitDTO.getQuantite());
            commande.getProduits().addAll(commandeProduits);
//          produit.setQuantite(produit.getQuantite()-commandeProduitDTO.getQuantite());
            produitRepository.saveAll(produits);
            return commandeRepository.save(commande);
        });
	}

}
