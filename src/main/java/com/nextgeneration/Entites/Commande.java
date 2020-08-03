package com.nextgeneration.Entites;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Column
	private Date dateCommande;
    @ManyToOne
    private Client client;
    @ManyToMany
    private List<Produit> produits;
    @OneToMany
    private List<Facture> factures;
    @OneToMany
    private List<Livraison> livraisons;
  
	
}
