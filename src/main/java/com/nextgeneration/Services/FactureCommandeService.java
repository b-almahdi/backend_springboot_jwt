package com.nextgeneration.Services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.Entites.Commande;
import com.nextgeneration.Entites.Facture;
import com.nextgeneration.Entites.Produit;
import com.nextgeneration.Repositories.CommandeRepository;
import com.nextgeneration.Repositories.FactureRepository;
import com.nextgeneration.dtos.CommandeFactureDTO;

@Service
public class FactureCommandeService {
	@Autowired
	FactureRepository factureRepository;
	@Autowired
	CommandeRepository commandeRepository;
	
	Commande commande;
	Facture facture;
	Produit produit;
	private double montant ;
	public Object generateFactureForCommande(CommandeFactureDTO commandeFactureDTO) {
		 commande = commandeRepository.findById(commandeFactureDTO.getIdCommande())
				 .orElseThrow(() -> 
				 new Error("Facture Generation Failed !"));
		if(commande.getFacture() != null) {
				throw new Error("Facture Generation Failed !");
			}
		 commande.getProduits().forEach( (produit) ->{
				montant = montant + (produit.getProduit().getPrix()*produit.getQuantite());
				});
		 	facture = new Facture();
			facture.setMontant(montant);
			factureRepository.save(facture);
			commande.setFacture(facture);
            return commandeRepository.save(commande);

	}
	

}
