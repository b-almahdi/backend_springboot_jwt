package com.nextgeneration.livraison;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Livraison {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Column
	private String adresse;
   
}
