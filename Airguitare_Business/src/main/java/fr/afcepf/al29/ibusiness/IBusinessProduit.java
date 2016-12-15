package fr.afcepf.al29.ibusiness;

import java.util.List;

import fr.afcepf.al29.airguitare.dto.DTOMarque;
import fr.afcepf.al29.airguitare.dto.DTOProduit;
import fr.afcepf.al29.airguitare.entities.Marque;

/**
 * 
 */
public interface IBusinessProduit {

	List<DTOProduit> getAllProduits();

    List<DTOProduit> getAllArticleBySpecialisation(String specialisationProduit);
    
	List<DTOMarque> getAllMarque();
    
	List<DTOMarque> getMarqueBySpecialisationProduit(String specialisationProduit);
}