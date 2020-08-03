package com.nextgeneration.Repositories;

import com.nextgeneration.Entites.Commande;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Integer> {

}
