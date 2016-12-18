package fr.afcepf.al29.ibusiness;

import java.util.List;

import fr.afcepf.al29.airguitare.dto.DTOCommande;

/**
 * 
 */
public interface IBusinessCommande {
	List<DTOCommande> getCommandesByUser(int idUser);
}