package com.nextgeneration.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextgeneration.Entites.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
