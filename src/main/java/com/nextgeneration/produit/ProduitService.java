package com.nextgeneration.produit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {
	
	@Autowired
    private ProduitRepository produitRepository;
	
	public Produit saveProduit(Produit produit) {
		return produitRepository.save(produit);
	}
	
	public void deleteProduitById(int id) {
		produitRepository.deleteById(id);
	}
	
	public Iterable<Produit> getAllProduit(){
		return produitRepository.findAll();
	}
	
	public Produit getProduitById(int id) {
		Optional<Produit> produit = produitRepository.findById(id);
		return produit.get();
	}
	
	public Produit updateProduit(int id,Produit produit) {
		Produit produit1 = produitRepository.findById(id).get();
		produit1.setNom(produit.getNom());
		produit1.setPrix(produit.getPrix());
		produit1.setType(produit.getType());
		produit1.setQuantite(produit.getQuantite());
		return produitRepository.save(produit1);
	}

	public Iterable<Produit> getProduitByNom(String nom) {
		return produitRepository.findByNomIgnoreCaseContaining(nom);
	}

	public Iterable<Produit> getProduitByType(String type) {
		return produitRepository.findByType(type);
	}

}
