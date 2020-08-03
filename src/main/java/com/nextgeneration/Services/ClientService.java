package com.nextgeneration.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgeneration.Entites.Client;
import com.nextgeneration.Repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
    private ClientRepository clientRepository;
	
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}
	
	public void deleteClientById(int id) {
		clientRepository.deleteById(id);
	}
	
	public Iterable<Client> getAllClient(){
		return clientRepository.findAll();
	}
	
	public Client getClientById(int id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}
	
	public Client updateClient(int id,Client client) {
		Client client1 = clientRepository.findById(id).get();
		client1.setNom(client.getNom());
		client1.setPrenom(client.getPrenom());
		client1.setAdresse(client.getAdresse());
		client1.setTelephone(client.getTelephone());
		return clientRepository.save(client1);
	}
	
	
}
