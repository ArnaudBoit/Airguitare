package fr.afcepf.al29.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al29.airguitare.api.IDAOAvisClient;
import fr.afcepf.al29.airguitare.api.IDAOClient;
import fr.afcepf.al29.airguitare.api.IDAOCommande;
import fr.afcepf.al29.airguitare.api.IDAOMarque;
import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.api.IDAOSpecialisationProduit;
import fr.afcepf.al29.airguitare.api.IDAOTypeProduit;
import fr.afcepf.al29.airguitare.dto.DTOMarque;
import fr.afcepf.al29.airguitare.dto.DTOProduit;
import fr.afcepf.al29.airguitare.dto.DTOSpecialisationProduit;
import fr.afcepf.al29.airguitare.entities.Marque;
import fr.afcepf.al29.airguitare.entities.Produit;
import fr.afcepf.al29.airguitare.entities.SpecialisationProduit;
import fr.afcepf.al29.ibusiness.IBusinessProduit;

/**
 * 
 */
@Stateless
public class BusinessProduit implements IBusinessProduit {
   
	@EJB
    private IDAOProduit DAOProduit;
	@EJB
    private IDAOMarque DAOMarque;
	@EJB
    private IDAOSpecialisationProduit DAOSpecialisationProduit;
	
	public BusinessProduit(){
	/*	try {
			InitialContext initialContext = new InitialContext();
			DAOProduit = (IDAOProduit) initialContext.lookup("java:global/Airguitare_Ear-0.0.1-SNAPSHOT/Airguitare_Dao/DAOProduit!fr.afcepf.al29.airguitare.api.IDAOProduit");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	 */
	}	
	
    public List<DTOProduit> getAllProduits() {   
    	List<DTOProduit> liste = new ArrayList<>();
    	for (Produit produit : DAOProduit.getArticlesByType("guitare")) {
			DTOProduit dto = new DTOProduit(produit, true);
			liste.add(dto);
		}    	
		return liste;
    }

	public List<DTOMarque> getAllMarque() {
		List<DTOMarque> liste = new ArrayList<>();
		for (Marque marque : DAOMarque.getAll()) {
			DTOMarque dto = new DTOMarque(marque, false);
			liste.add(dto);
		}
		return liste;
	}

	public List<DTOSpecialisationProduit> getAllSpecs() {
		List<DTOSpecialisationProduit> liste = new ArrayList<>();
		for (SpecialisationProduit specialisationProduit : DAOSpecialisationProduit.getAll()) {
			DTOSpecialisationProduit dto = new DTOSpecialisationProduit(specialisationProduit, false);
			liste.add(dto);
		}
		return liste;
	}

	public List<DTOProduit> getProduitParOptions(String specialisations, String marques) {
    	List<DTOProduit> liste = new ArrayList<>();
    	String listeSpecialisation[] = specialisations.split(",");
    	String listeMarques[] = marques.split(",");
    	
    	//Récupère la liste de tous les produits
    	for (Produit produit : DAOProduit.getAll()) {
			DTOProduit dto = new DTOProduit(produit, true);

	    	//Trier par spécialisations sélectionnées
	    	for (String spec : listeSpecialisation) {
	    		if(spec.equals(dto.getSpecialisationProduit().getIntitule())) {
	    	    	//Trier par marques sélectionnées
	    	    	for (String marque : listeMarques) {
	    				if(marque.equals(dto.getMarque().getIntitule())) {
	    					liste.add(dto);
	    				}
	    			}
	    		}
	    	}			
		}  
		return liste;
	}


    
    
    
    

    /**
     * 
     */
    private IDAOCommande DAOCommande;

    /**
     * 
     */
    private IDAOAvisClient DAOAvisClient;

    /**
     * 
     */
    private IDAOClient DAOClient;
    
    
    
    private IDAOTypeProduit DAOTypeProduit;


    


}