package com.nextgeneration.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer>,QueryByExampleExecutor<Produit>  {
	//Produit findByNom(String nom);
	Iterable<Produit> findByType(String type);
	Iterable<Produit> findByNomIgnoreCaseContaining(String nom);
	Iterable<Produit> findByNom(String nom);
	Iterable<Produit> findByOrderByPrixAsc();
	Iterable<Produit> findByOrderByPrixDesc();
}
