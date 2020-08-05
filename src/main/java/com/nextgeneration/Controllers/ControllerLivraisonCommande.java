package com.nextgeneration.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.Entites.ResponseEntity;
import com.nextgeneration.Services.LivraisonCommandeService;
import com.nextgeneration.dtos.CommandeLivraisonDTO;

@RestController
@RequestMapping("/livraisons")
public class ControllerLivraisonCommande {
	
	@Autowired
	private LivraisonCommandeService livraisonCommandeService;
	ResponseEntity responseEntity;
	
	@PostMapping("/commandes")
	public ResponseEntity generateFactureForCommande(@RequestBody CommandeLivraisonDTO commandeLivraisonDTO) {
    	responseEntity = new ResponseEntity();
    	try{
    		return responseEntity.setMessage(livraisonCommandeService.generateLivraisonForCommande(commandeLivraisonDTO), 200);
    	}catch(Exception e) {
    		return responseEntity.setErrorMessage(e.getMessage(),403);
    	}
	}
	

}
