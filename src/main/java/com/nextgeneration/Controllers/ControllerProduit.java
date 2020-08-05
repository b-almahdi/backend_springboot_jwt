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

import com.nextgeneration.Entites.Produit;
import com.nextgeneration.Services.ProduitService;
import com.nextgeneration.dtos.ResponseEntity;

@RestController
@RequestMapping("/produits")
public class ControllerProduit {
	
	@Autowired
    ProduitService produitService;
	ResponseEntity responseEntity;
    
    @GetMapping("/")
    public ResponseEntity getProduits() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(produitService.getAllProduit(),200);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getProduit(@PathVariable("id") final int id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(produitService.getProduitById(id),200);
    }
    
    @GetMapping("/name/{nom}")
    public ResponseEntity getProduitByNom(@PathVariable("nom") final String nom ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(produitService.getProduitByNom(nom),200);
    }
    
    @GetMapping("/type/{type}")
    public ResponseEntity getProduitByType(@PathVariable("type") final String type ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(produitService.getProduitByType(type),200);
    }
    
    @PostMapping("")
    public ResponseEntity createProduit(@RequestBody Produit produit) {
    	try {
    		responseEntity = new ResponseEntity();
        	return responseEntity.setMessage(produitService.saveProduit(produit),200);
    	}catch(Exception e) {
    		responseEntity = new ResponseEntity();
        	return responseEntity.setErrorMessage(e.getMessage(), 403);
    	}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduit(@PathVariable("id") final int id ) {
    	responseEntity = new ResponseEntity();
    	produitService.deleteProduitById(id);
    	return responseEntity.setMessage("deleted successful:",200);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateProduit(@PathVariable("id") final int id, @RequestBody Produit produit) {
    	try{
    		responseEntity = new ResponseEntity();
        	return responseEntity.setMessage(produitService.updateProduit(id, produit),200);
    	}catch(Exception e) {
    		responseEntity = new ResponseEntity();
        	return responseEntity.setErrorMessage("update unsuccessful", 403);
    	}
    }
    


}
