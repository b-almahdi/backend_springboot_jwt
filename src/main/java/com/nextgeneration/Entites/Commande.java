package com.nextgeneration.Entites;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
    @OneToMany(cascade = {CascadeType.ALL})
    private List<CommandeProduit> produits;
    @OneToOne
    private Facture facture;
    @OneToOne
    private Livraison livraison;
  
	
}
