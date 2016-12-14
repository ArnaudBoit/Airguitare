package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.Marque;
import fr.afcepf.al29.airguitare.entities.Produit;

public interface IDAOMarque {
	
	List<Marque> getAll();

	List<Marque> getMarqueBySpecialisationProduit(String specialisationProduit);


}
