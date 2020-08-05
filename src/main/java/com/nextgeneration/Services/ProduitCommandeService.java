package com.nextgeneration.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.Entites.CommandeProduit;
import com.nextgeneration.Entites.Produit;
import com.nextgeneration.Repositories.CommandeRepository;
import com.nextgeneration.Repositories.ProduitRepository;
import com.nextgeneration.dtos.CommandeProduitDTO;

@Service
public class ProduitCommandeService {
	
	@Autowired
    private ProduitRepository produitRepository;
	@Autowired 
	private CommandeRepository commandeRepository;

	CommandeProduit commandeProduit;
	Produit produit;
	
	public Optional<Object> addProduitToCommande(CommandeProduitDTO commandeProduitDTO) {
		commandeProduit = new CommandeProduit();
		return commandeRepository.findById(commandeProduitDTO.getIdCommande()).map(commande -> {
			produit = produitRepository.findById(commandeProduitDTO.getIdProduit()).get();
			if(produit.getQuantite()<commandeProduitDTO.getQuantite()) {
				throw new Error("Out of stock");
			}
			commandeProduit.setProduit(produit);
			commandeProduit.setQuantite(commandeProduitDTO.getQuantite());
            commande.getProduits().add(commandeProduit);
            produit.setQuantite(produit.getQuantite()-commandeProduitDTO.getQuantite());
            produitRepository.save(produit);
            return commandeRepository.save(commande);
        });
	}

}
