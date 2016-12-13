package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.SpecialisationProduit;
import fr.afcepf.al29.airguitare.entities.TypeProduit;

public interface IDAOSpecialisationProduit {
	
	List<SpecialisationProduit> getSpecialisationProduitByTypeProduit(String typeProduit);

}
