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
<<<<<<< HEAD

		commande = commandeRepository.findById(commandeLivraisonDTO.getIdCommande())
				.orElseThrow(() -> new Error("Livraison Failed !"));
		if (commande.getLivraison() != null) {
			throw new Error("Livraison Failed !");
		}
		if (commande.getFacture() == null) {
			throw new Error("Facture not created!");
		}

		livraison = new Livraison();
		livraison.setAdresse(commandeLivraisonDTO.getAdresse());
		livraisonRepository.save(livraison);
		commande.setLivraison(livraison);
		return commandeRepository.save(commande);
=======
<<<<<<< HEAD
		commande = commandeRepository.findById(CommandeLivraisonDTO.getIdCommande())
=======
/*	commande = commandeRepository.findById(CommandeLivraisonDTO.getIdCommande())
>>>>>>> 5a31153cc70629db314db809594384d4f3d04a7c
				 .orElseThrow(() -> 
				 new Error("Livraison Failed !"));
		if(commande.getLivraison() != null) {
				throw new Error("Livraison Failed !");
			}

		 	livraison = new Livraison();
<<<<<<< HEAD
		 	livraison.setAddress(CommandeLivraisonDTO.getAdresse());
		 	livraisonRepository.save(livraison);
			commande.setFacture(facture);
=======
		 	livraison.setAdresse(CommandeLivraisonDTO.getAdresse());
		 	livraison.setDateReception(CommandeLivraisonDTO.getDateReception());
		 	livraisonRepository.save(livraison);
			commande.setLivraison(livraison);*/
>>>>>>> 5a31153cc70629db314db809594384d4f3d04a7c
           return commandeRepository.save(commande);
>>>>>>> 04b971446ef9ba60bf5153e1bf93a5df18e18329
	}

}
