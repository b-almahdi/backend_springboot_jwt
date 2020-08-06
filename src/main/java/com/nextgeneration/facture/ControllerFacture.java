package com.nextgeneration.facture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.globals.ResponseEntity;

@RestController
@RequestMapping("factures")
public class ControllerFacture {
	
	@Autowired
    FactureService factureService;
	ResponseEntity responseEntity;
    Facture facture;

    
    @GetMapping("/")
    public ResponseEntity getFactures() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(factureService.getAllFacture(),200);

    }
    
    @GetMapping("/{id}")
    public ResponseEntity getFacture(@PathVariable("id") final int id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(factureService.getFactureById(id),200);
    }

}
