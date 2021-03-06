package com.nextgeneration.commandeFacture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.globals.ResponseEntity;

@RestController
@RequestMapping("/factures")
public class ControllerFactureCommande {
	
	@Autowired
	private FactureCommandeService factureCommandeService;
	ResponseEntity responseEntity;
	
	@PostMapping("/commandes")
	public ResponseEntity generateFactureForCommande(@RequestBody CommandeFactureDTO commandeFactureDTO) {
    	responseEntity = new ResponseEntity();
    	try{
    		return responseEntity.setMessage(factureCommandeService.generateFactureForCommande(commandeFactureDTO), 200);
    	}catch(Exception e) {
    		return responseEntity.setErrorMessage(e.getMessage(),403);
    	}
	}
	

}
