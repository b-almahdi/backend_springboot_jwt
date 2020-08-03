package com.nextgeneration.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.Entites.Produit;
import com.nextgeneration.Repositories.ProduitRepository;

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
		produit1.setNomProduit(produit.getNomProduit());
		produit1.setPrix(produit.getPrix());
		produit1.setQuantite(produit.getQuantite());
		return produitRepository.save(produit1);
	}
}
