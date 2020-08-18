package com.nextgeneration.client;

import static com.nextgeneration.Security.SecurityConstants.TOKEN_PREFIX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgeneration.Security.JwtTokenProvider;
import com.nextgeneration.globals.ResponseEntity;
import com.nextgeneration.payload.JWTLoginSucessReponse;
import com.nextgeneration.payload.LoginRequest;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/clients")
public class ControllerClient {
	
	@Autowired
    ClientService clientService;
    Client client;
    ResponseEntity responseEntity;

    
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity authenticateUser( @RequestBody LoginRequest loginRequest){
    	ResponseEntity responseEntity = new ResponseEntity();
    	try {
    		Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = TOKEN_PREFIX +  tokenProvider.generateToken(authentication);
            return responseEntity.setMessage(new JWTLoginSucessReponse(true, jwt),200);
		} catch (Exception e) {
			
			return responseEntity.setErrorMessage(e.getMessage(), 401);		}

    }
    
    
    @PostMapping("/signup")
    public ResponseEntity createClient(@RequestBody Client client) {
    	try{
    		responseEntity = new ResponseEntity();
    		return responseEntity.setMessage(clientService.saveClient(client),200);
    	}catch(Exception e) {
    		return responseEntity.setErrorMessage(e.getMessage(), 403);
    	}
    	
    }
    
    @GetMapping("/")
    public ResponseEntity getClients() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(clientService.getAllClient(), 200);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getClient(@PathVariable("id") final int id ) {
        return responseEntity.setMessage(clientService.getClientById(id),200);
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
