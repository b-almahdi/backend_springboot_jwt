package com.nextgeneration.dtos;

import java.util.List;

import lombok.Data;

@Data
public class CommandeProduitDTO {
	
	private int idCommande;
	private List<ProduitQuantiteDTO> produits;

}
