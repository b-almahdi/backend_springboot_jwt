package com.nextgeneration.Controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.Entites.Livraison;
import com.nextgeneration.Services.LivraisonService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerLivraison {

	@Autowired
    LivraisonService livraisonService;
    Livraison livraison;

    
    @GetMapping("/livraisons")
    public Collection<Livraison> coolLivraisons() {
    	Collection<Livraison> livraisons = new ArrayList<>();
    	for(Livraison c : livraisonService.getAllLivraison()) {
    		livraisons.add(c);
    	}
        return livraisons;
    }
    
    @GetMapping("/livraison={id}")
    public Livraison getLivraison(@PathVariable("id") final int id ) {
        return livraisonService.getLivraisonById(id);
    }
}
