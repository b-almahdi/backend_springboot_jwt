package com.nextgeneration.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.Entites.Commande;
import com.nextgeneration.Entites.Facture;
import com.nextgeneration.Repositories.CommandeRepository;
import com.nextgeneration.Repositories.FactureRepository;
import com.nextgeneration.dtos.CommandeFactureLivraisonDTO;

@Service
public class FactureCommandeService {

	@Autowired
	FactureRepository factureepository;
	@Autowired
	CommandeRepository commandeRepository;
		Facture facture;
		Commande commande;
	public Object generateFactureForCommande(CommandeFactureLivraisonDTO commandeFactureLivraisonDTO) {
		commandeRepository.findById(CommandeFactureLivraisonDTO.getIdCommande()).map(commande -> {
			if(produit.getQuantite()<commandeProduitDTO.getQuantite()) {
				throw new Error("Out of stock");
			}
			commandeProduit.setProduit(produit);
			commandeProduit.setQuantite(commandeProduitDTO.getQuantite());
            commande.getProduits().add(commandeProduit);
            produit.setQuantite(produit.getQuantite()-commandeProduitDTO.getQuantite());
            produitRepository.save(produit);
            return commandeRepository.save(commande);

	}
	
	

}
