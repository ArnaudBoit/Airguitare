package fr.afcepf.al29.ibusiness;

import java.util.*;

import javax.ejb.Local;

import fr.afcepf.al29.airguitare.dto.DTOProduit;

/**
 * 
 */
@Local
public interface IBusinessProduit {
	
	List<DTOProduit> getAllProduits();

}