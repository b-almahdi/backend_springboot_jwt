package com.nextgeneration.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.Entites.Livraison;
import com.nextgeneration.Repositories.LivraisonRepository;

@Service
public class LivraisonService {

	@Autowired
    private LivraisonRepository livraisonRepository;
	
	public void saveLivraison(Livraison livraison) {
		livraisonRepository.save(livraison);
	}
	
	public void deleteLivraisonById(int id) {
		livraisonRepository.deleteById(id);
	}
	
	public Iterable<Livraison> getAllLivraison(){
		return livraisonRepository.findAll();
	}
	
	public Livraison getLivraisonById(int id) {
		Optional<Livraison> livraison = livraisonRepository.findById(id);
		return livraison.get();
	}
	
	public void updateLivraison(int id,Livraison livraison) {
		Livraison livraison1 = livraisonRepository.findById(id).get();
		livraison1.setDateLivraison(livraison.getDateLivraison());
		livraisonRepository.save(livraison1);
	}
}
