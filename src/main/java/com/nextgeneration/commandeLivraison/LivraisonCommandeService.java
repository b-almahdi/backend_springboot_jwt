package com.nextgeneration.commandeLivraison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.commande.Commande;
import com.nextgeneration.commande.CommandeRepository;
import com.nextgeneration.livraison.Livraison;
import com.nextgeneration.livraison.LivraisonRepository;

@Service
public class LivraisonCommandeService {

	@Autowired
	LivraisonRepository livraisonRepository;
	@Autowired
	CommandeRepository commandeRepository;

	Commande commande;
	Livraison livraison;

	public Object generateLivraisonForCommande(CommandeLivraisonDTO commandeLivraisonDTO) {

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
	}

}
