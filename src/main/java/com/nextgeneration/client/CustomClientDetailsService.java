package com.nextgeneration.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomClientDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);
        if(client==null) { 
        	throw new UsernameNotFoundException("User not found");
        }
        else {
        return client;
        }
    }


    @Transactional
    public Client loadUserById(Long id){
    	Client client = clientRepository.getById(id);
        if(client==null) new UsernameNotFoundException("User not found");
        return client;

    }
}
