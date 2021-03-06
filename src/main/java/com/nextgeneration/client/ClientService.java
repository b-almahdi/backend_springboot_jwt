package com.nextgeneration.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nextgeneration.exceptions.UsernameAlreadyExistsException;

@Service
public class ClientService {

	@Autowired
    private ClientRepository clientRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public Client saveClient(Client client) {
		try {
			client.setPassword(passwordEncoder.encode(client.getPassword()));
			return clientRepository.save(client);
		}catch (Exception e) {
			System.out.println(e);
			throw new UsernameAlreadyExistsException("Username '"+client.getUsername()+"' already exists");
		}
		

	}
	
	public void deleteClientById(int id) {
		try {
			clientRepository.deleteById(id);			
		} catch (Exception e) {
			throw new Error("delete unsuccessful!");
		}
	}
	
	public Iterable<Client> getAllClient(){
		return clientRepository.findAll();
	}
	
	public Client getClientById(int id) {
		try {			
			Optional<Client> client = clientRepository.findById(id);
			return client.get();
		} catch (Exception e) {
			throw new Error("Invalid save");
		}
	}
	
	public Client updateClient(int id,Client client) {
		try {			
			Client client1 = clientRepository.findById(id).get();
			client1.setNom(client.getNom());
			client1.setPrenom(client.getPrenom());
			client1.setAdresse(client.getAdresse());
			client1.setTelephone(client.getTelephone());
			return clientRepository.save(client1);
		} catch (Exception e) {
			throw new Error("update unsuccessful!");
		}
	}
	
	
}
