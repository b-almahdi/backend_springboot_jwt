package com.nextgeneration.facture;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureService {
	
	@Autowired
    private FactureRepository factureRepository;
	
	public void saveFacture(Facture facture) {
		factureRepository.save(facture);
	}
	
	public void deleteFactureById(int id) {
		factureRepository.deleteById(id);
	}
	
	public Iterable<Facture> getAllFacture(){
		return factureRepository.findAll();
	}
	
	public Facture getFactureById(int id) {
		Optional<Facture> facture = factureRepository.findById(id);
		return facture.get();
	}
	
	public void updateFacture(int id,Facture facture) {
		Facture facture1 = factureRepository.findById(id).get();
		facture1.setMontant(facture.getMontant());
		factureRepository.save(facture1);
	}
}
