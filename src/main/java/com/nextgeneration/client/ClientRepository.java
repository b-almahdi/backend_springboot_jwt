package com.nextgeneration.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	Client findByUsername(String username);

	Client getById(Long id);

}
