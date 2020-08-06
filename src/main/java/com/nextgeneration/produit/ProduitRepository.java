package com.nextgeneration.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
	Produit findByNom(String nom);
	Iterable<Produit> findByType(String type);
}
