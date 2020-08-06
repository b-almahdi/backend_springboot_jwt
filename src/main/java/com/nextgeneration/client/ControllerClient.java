package com.nextgeneration.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.globals.ResponseEntity;

@RestController
@RequestMapping("/clients")
public class ControllerClient {
	
	@Autowired
    ClientService clientService;
    Client client;
    ResponseEntity responseEntity;

    
    @GetMapping("/")
    public ResponseEntity getClients() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(clientService.getAllClient(), 200);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getClient(@PathVariable("id") final int id ) {
        return responseEntity.setMessage(clientService.getClientById(id),200);
    }
    
    @PostMapping("/")
    public ResponseEntity createClient(@RequestBody Client client) {
    	try{
    		responseEntity = new ResponseEntity();
    		return responseEntity.setMessage(clientService.saveClient(client),200);
    	}catch(Exception e) {
    		return responseEntity.setErrorMessage(e.getMessage(), 403);
    	}
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") final int id ) {
        try{
        	clientService.deleteClientById(id);
        	return responseEntity.setMessage("delete successful!",200);
        }catch(Exception e) {
        	return responseEntity.setErrorMessage("delete unsuccessful!",403);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable("id") final int id, @RequestBody Client client) {
    	try{
    		return responseEntity.setMessage(clientService.updateClient(id, client),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage("update unsuccessful!",403);
    	}
    }

}
