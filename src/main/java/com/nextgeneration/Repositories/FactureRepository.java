package com.nextgeneration.Repositories;

import com.nextgeneration.Entites.Facture;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Integer> {

}