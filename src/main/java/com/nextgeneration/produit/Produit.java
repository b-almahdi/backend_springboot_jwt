package com.nextgeneration.produit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Column
	private String nom;
    @Column
	private int quantite;
    @Column
    private String description;
    @Column
	private double prix;
    @Column
	private String taille;
    @Column
	private String type;
    @Column
    private String imageUrl;
    
}
