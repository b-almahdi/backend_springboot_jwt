package com.nextgeneration.commande;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.nextgeneration.commandeProduit.CommandeProduit;
import com.nextgeneration.facture.Facture;
import com.nextgeneration.livraison.Livraison;

import lombok.Data;

@Data
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Column
	private Date dateCommande;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<CommandeProduit> produits;
    @OneToOne
    private Facture facture;
    @OneToOne
    private Livraison livraison;
  
	
}
