package com.nextgeneration.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextgeneration.Entites.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
	Produit findByNom(String nom);
	Iterable<Produit> findByType(String type);
}
