package com.nextgeneration.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class CommandeLivraisonDTO {
	
	private int idCommande;
	private Date dateReception;
	private String adresse;

}
