package fr.afcepf.al29.ibusiness;

import java.util.List;

import fr.afcepf.al29.airguitare.dto.DTOMarque;
import fr.afcepf.al29.airguitare.dto.DTOProduit;
import fr.afcepf.al29.airguitare.dto.DTOSpecialisationProduit;

/**
 * 
 */

public interface IBusinessProduit {

	List<DTOProduit> getAllProduits();
    
	List<DTOMarque> getAllMarque();

	List<DTOSpecialisationProduit> getAllSpecs();
	
	List<DTOProduit> getProduitParOptions(String specialisations, String marques);
	
	DTOProduit getProduitById (int idProduit);
}