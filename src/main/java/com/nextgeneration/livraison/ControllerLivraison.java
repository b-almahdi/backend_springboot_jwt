package com.nextgeneration.livraison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.globals.ResponseEntity;

@RestController
@RequestMapping("livraisons")
public class ControllerLivraison {

	@Autowired
    LivraisonService livraisonService;
	ResponseEntity responseEntity;
    Livraison livraison;

    
    @GetMapping("/")
    public ResponseEntity getLivraisons() {
    	responseEntity = new ResponseEntity();
        return responseEntity.setMessage(livraisonService.getAllLivraison(), 200);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getLivraison(@PathVariable("id") final int id ) {
    	responseEntity = new ResponseEntity();
        return responseEntity.setMessage(livraisonService.getLivraisonById(id),200);
    }
}
