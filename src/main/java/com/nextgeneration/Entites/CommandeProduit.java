package com.nextgeneration.Entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class CommandeProduit {
	
	@Id
	@JsonIgnore
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = {CascadeType.ALL})
	private Produit produit;
    @Column
	private Integer quantite;

}
