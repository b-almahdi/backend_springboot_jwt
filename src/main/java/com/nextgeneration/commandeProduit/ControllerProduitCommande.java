package com.nextgeneration.commandeProduit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.globals.ResponseEntity;
import com.nextgeneration.produit.Produit;

@RestController
@RequestMapping("/produits")
public class ControllerProduitCommande {
	
	@Autowired
	ProduitCommandeService produitCommandeService;
    Produit produit;
    ResponseEntity responseEntity;
	
    @PostMapping("/commandes/")
    public ResponseEntity addProduitToCommande(@RequestBody CommandeProduitDTO commandeProduitDTO) {
    	responseEntity = new ResponseEntity();
    	try{
    		return responseEntity.setMessage(produitCommandeService.addProduitToCommande(commandeProduitDTO), 200);
    	}catch(Exception e) {
    		return responseEntity.setErrorMessage(e.getMessage(),403);
    	}
    }
    
}
