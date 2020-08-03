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
import com.nextgeneration.Entites.Commande;
import com.nextgeneration.Services.CommandeService;

@RestController
@RequestMapping("/commandes")
public class ControllerCommande {
	
	
	@Autowired
    CommandeService commandeService;
    Commande commande;

    
    @GetMapping("/")
    public Iterable<Commande> getCommandes() {
    	return commandeService.getAllCommande();
    }
    
    @GetMapping("/{id}")
    public Commande getCommande(@PathVariable("id") final int id ) {
        return commandeService.getCommandeById(id);
    }
    
    @PostMapping("/")
    public Commande createCommande(@RequestBody Commande commande) {
    	try{
    		return commandeService.saveCommande(commande);
    	}catch(Exception e) {
    		return null;
    	}
    	
    }
    
    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable("id") final int id ) {
    	commandeService.deleteCommandeById(id);
    }
    
    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable("id") final int id, @RequestBody Commande commande) {
    	try{
    		return commandeService.updateCommande(id, commande);
    	}catch(Exception e) {
    		return null;
    	}
    }

}
