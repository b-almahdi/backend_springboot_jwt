package com.nextgeneration.client;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.nextgeneration.commande.Commande;

import lombok.Data;

@Data
@Entity
public class Client /*extends Auditable<String>*/ {
	

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Column
	private String nom;
    @Column
	private String prenom;
    @Column
	private String adresse;
    @Column
	private String telephone;
    @OneToMany
    private List<Commande> commandes;
    
}
