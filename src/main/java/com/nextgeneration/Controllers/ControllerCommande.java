package com.nextgeneration.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.Entites.Client;
import com.nextgeneration.Entites.Commande;
import com.nextgeneration.Entites.ResponseEntity;
import com.nextgeneration.Services.CommandeService;

@RestController
@RequestMapping("/commandes")
public class ControllerCommande {
	
	
	@Autowired
    CommandeService commandeService;
	ResponseEntity responseEntity;
    Commande commande;

    
    @GetMapping("/")
    public Iterable<Commande> getCommandes() {
    	return commandeService.getAllCommande();
    }
    
    @GetMapping("/{id}/produits")
    public ResponseEntity getProduitsCommande(@PathVariable("id") final int id ) {
    	responseEntity = new ResponseEntity();
    	try{
    		return responseEntity.setMessage(commandeService.getAllProduitsByCommande(id),200);
    	}catch(Exception e) {
    		return responseEntity.setMessage("unsuccessful return!",403);
    	}
    }
    
    @GetMapping("/{id}")
    public Commande getCommande(@PathVariable("id") final int id ) {
        return commandeService.getCommandeById(id);
    }
    
    @PostMapping("/")
    public ResponseEntity createCommande(@RequestBody Commande commande, @RequestHeader Integer id) {
    	responseEntity = new ResponseEntity();
    	try{
    		return responseEntity.setMessage(commandeService.saveCommande(commande,id),200);
    	}catch(Exception e) {
    		return responseEntity.setMessage("create unsuccessful!",403);
    	}
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCommande(@PathVariable("id") final int id ) {
    	try{
    		commandeService.deleteCommandeById(id);
    		return responseEntity.setMessage("delete successful!", 200);
    	}catch(Exception e) {
    		return responseEntity.setErrorMessage("delete unsuccessful!", 403);
    	}
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateCommande(@PathVariable("id") final int id, @RequestBody Commande commande) {
    	try{
    		return responseEntity.setMessage(commandeService.updateCommande(id, commande),200);
    	}catch(Exception e) {
    		return responseEntity.setErrorMessage("update unsuccessful!", 403);
    	}
    }

}
