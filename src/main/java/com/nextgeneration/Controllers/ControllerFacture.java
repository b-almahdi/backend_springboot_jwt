package com.nextgeneration.Controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.Entites.Facture;
import com.nextgeneration.Services.FactureService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerFacture {
	
	@Autowired
    FactureService factureService;
    Facture facture;

    
    @GetMapping("/factures")
    public Collection<Facture> coolFactures() {
    	Collection<Facture> factures = new ArrayList<>();
    	for(Facture c : factureService.getAllFacture()) {
    		factures.add(c);
    	}
        return factures;
    }
    
    @GetMapping("/facture={id}")
    public Facture getFacture(@PathVariable("id") final int id ) {
        return factureService.getFactureById(id);
    }

}
