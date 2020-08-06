package com.nextgeneration.commandeProduit;

import java.util.List;

import lombok.Data;

@Data
public class CommandeProduitDTO {
	
	private int idCommande;
	private List<ProduitQuantiteDTO> produits;

}
