package com.nextgeneration.commandeFacture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.commande.Commande;
import com.nextgeneration.commande.CommandeRepository;
import com.nextgeneration.facture.Facture;
import com.nextgeneration.facture.FactureRepository;
import com.nextgeneration.produit.Produit;

@Service
public class FactureCommandeService {
	@Autowired
	FactureRepository factureRepository;
	@Autowired
	CommandeRepository commandeRepository;

	Commande commande;
	Facture facture;
	Produit produit;
	private double montant = 0;

	public Object generateFactureForCommande(CommandeFactureDTO commandeFactureDTO) {
		commande = commandeRepository.findById(commandeFactureDTO.getIdCommande())
				.orElseThrow(() -> new Error("Facture Generation Failed !"));
		if (commande.getFacture() != null) {
			throw new Error("Facture Generation Failed !");
		}
		commande.getProduits().forEach((produit) -> {
			montant += produit.getProduit().getPrix() * produit.getQuantite();
		});
		facture = new Facture();
		facture.setMontant(montant);
		factureRepository.save(facture);
		commande.setFacture(facture);
		return commandeRepository.save(commande);

	}

}
