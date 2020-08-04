package com.nextgeneration.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextgeneration.Entites.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
