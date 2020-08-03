package com.nextgeneration.Repositories;

import com.nextgeneration.Entites.Produit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {

}
