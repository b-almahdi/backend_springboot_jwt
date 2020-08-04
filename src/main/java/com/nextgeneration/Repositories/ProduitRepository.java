package com.nextgeneration.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nextgeneration.Entites.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
	Produit findByNom(String nom);
	Iterable<Produit> findByType(String type);
}
