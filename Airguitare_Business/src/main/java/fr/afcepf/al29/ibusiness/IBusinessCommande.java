package fr.afcepf.al29.ibusiness;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al29.airguitare.dto.DTOCommande;
import fr.afcepf.al29.airguitare.dto.DTOLigneCommande;

/**
 * 
 */
@Local
public interface IBusinessCommande {
	List<DTOCommande> getCommandesByUser(int idUser);

	double getPrixByCommande(int idCommande);
}