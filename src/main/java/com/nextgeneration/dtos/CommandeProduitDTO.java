package com.nextgeneration.dtos;

import lombok.Data;

@Data
public class CommandeProduitDTO {
	
	private int idCommande;
	private int idProduit;
	private int quantite;

}
