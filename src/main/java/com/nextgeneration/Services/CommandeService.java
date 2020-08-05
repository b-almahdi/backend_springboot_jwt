package com.nextgeneration.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.Entites.Commande;
import com.nextgeneration.Entites.CommandeProduit;
import com.nextgeneration.Entites.Produit;
import com.nextgeneration.Repositories.ClientRepository;
import com.nextgeneration.Repositories.CommandeRepository;

@Service
public class CommandeService {
	
	@Autowired
    private CommandeRepository commandeRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	public Optional<Object> saveCommande(Commande commande, Integer idClient) {
		commande.setDateCommande(new Date());
		return clientRepository.findById(idClient).map(client -> {
            client.getCommandes().add(commande);
            return commandeRepository.save(commande);
        });
	}
	
	public void deleteCommandeById(int id) {
		commandeRepository.deleteById(id);
	}
	
	public Iterable<Commande> getAllCommande(){
		return commandeRepository.findAll();
	}
	
	public Commande getCommandeById(int id) {
		Optional<Commande> commande = commandeRepository.findById(id);
		return commande.get();
	}
	
	public Commande updateCommande(int id,Commande commande) {
		Commande commande1 = commandeRepository.findById(id).get();
		commande1.setDateCommande(new Date());
		return commandeRepository.save(commande1);
	}

	public List<CommandeProduit> getAllProduitsByCommande(int id) {
		Optional<Commande> commande = commandeRepository.findById(id);
//		List<Produit> produits = new ArrayList<>();
//		commande.get().getProduits().forEach(commandeProduit -> {
//			commandeProduit.getProduit();
//		});
		return commande.get().getProduits();
	}

}
