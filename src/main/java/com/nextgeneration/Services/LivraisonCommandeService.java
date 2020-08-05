package com.nextgeneration.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.Entites.Commande;
import com.nextgeneration.Entites.Livraison;
import com.nextgeneration.Repositories.CommandeRepository;
import com.nextgeneration.Repositories.LivraisonRepository;
import com.nextgeneration.dtos.CommandeLivraisonDTO;

@Service
public class LivraisonCommandeService {

	@Autowired
	LivraisonRepository livraisonRepository;
	@Autowired
	CommandeRepository commandeRepository;
	
	Commande commande;
	Livraison livraison;

	public Object generateLivraisonForCommande(CommandeLivraisonDTO commandeLivraisonDTO) {
/*	commande = commandeRepository.findById(CommandeLivraisonDTO.getIdCommande())
				 .orElseThrow(() -> 
				 new Error("Livraison Failed !"));
		if(commande.getLivraison() != null) {
				throw new Error("Livraison Failed !");
			}

		 	livraison = new Livraison();
		 	livraison.setAdresse(CommandeLivraisonDTO.getAdresse());
		 	livraison.setDateReception(CommandeLivraisonDTO.getDateReception());
		 	livraisonRepository.save(livraison);
			commande.setLivraison(livraison);*/
           return commandeRepository.save(commande);
	}
	
	

}
