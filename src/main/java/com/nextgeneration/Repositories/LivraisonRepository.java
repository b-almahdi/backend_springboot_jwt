package com.nextgeneration.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextgeneration.Entites.Livraison;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Integer> {

}
