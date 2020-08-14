package com.nextgeneration.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.globals.ResponseEntity;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
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
    /*
    @GetMapping("")
    public ResponseEntity getProduitByNom(@RequestParam(required = false) final String nom ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(produitService.getProduitByNom(nom),200);
    }*/
    
    @GetMapping("")
    public ResponseEntity getProduitByPrix (@RequestParam("sort") String sort) {
    	responseEntity = new ResponseEntity();
    	if(sort.toUpperCase()=="ASC") {
    	return  responseEntity.setMessage(produitService.getProduitByPriceAsc(),200);
    	}
    	else if (sort.toUpperCase()=="DESC") {
    	return responseEntity.setMessage(produitService.getProduitByPriceDesc(),200);
    	}
    	else {
    		return responseEntity.setMessage(produitService.getAllProduit(),200);
    	}
    	
    }

    
    @GetMapping("/type/{type}")
    public ResponseEntity getProduitByType(@PathVariable("type") final String type ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(produitService.getProduitByType(type),200 );
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
    	try {
    	responseEntity = new ResponseEntity();
    	produitService.deleteProduitById(id);
    	return responseEntity.setMessage("deleted successful:",200);
	}catch(Exception e) {
		responseEntity = new ResponseEntity();
    	return responseEntity.setErrorMessage(e.getMessage(), 403);
	}
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
