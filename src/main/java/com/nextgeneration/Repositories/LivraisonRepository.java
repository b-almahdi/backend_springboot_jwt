package com.nextgeneration.Repositories;

import com.nextgeneration.Entites.Livraison;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivraisonRepository extends CrudRepository<Livraison, Integer> {

}
