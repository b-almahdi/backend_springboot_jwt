package com.nextgeneration.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.Entites.Client;
import com.nextgeneration.Entites.Produit;
import com.nextgeneration.Services.ProduitService;

@RestController
@RequestMapping("/produits")
public class ControllerProduit {
	
	@Autowired
    ProduitService produitService;
    Produit produit;

    
    @GetMapping("/")
    public Iterable<Produit> getProduits() {
    	return produitService.getAllProduit();
    }
    
    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable("id") final int id ) {
        return produitService.getProduitById(id);
    }
    
    @PostMapping("")
    public Produit createProduit(@RequestBody Produit produit) {
    	try {
    		return produitService.saveProduit(produit);
    	}catch(Exception e) {
    		return null;
    	}
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable("id") final int id ) {
        produitService.deleteProduitById(id);
    }
    
    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable("id") final int id, @RequestBody Produit produit) {
    	try{
    		return produitService.updateProduit(id, produit);
    	}catch(Exception e) {
    		return null;
    	}
    }

}
