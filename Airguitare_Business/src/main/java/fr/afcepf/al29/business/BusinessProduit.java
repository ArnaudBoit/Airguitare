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
import fr.afcepf.al29.airguitare.dto.DTOProduit;
import fr.afcepf.al29.airguitare.entities.Produit;
import fr.afcepf.al29.ibusiness.IBusinessProduit;

/**
 * 
 */
@Stateless
public class BusinessProduit implements IBusinessProduit {
   
	@EJB
    private IDAOProduit DAOProduit;
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
    	System.out.println("size : " + DAOProduit.getArticlesByType("guitare").size());
    	
    	List<DTOProduit> liste = new ArrayList<>();
    	for (Produit produit : DAOProduit.getArticlesByType("guitare")) {
			DTOProduit dto = new DTOProduit(produit, false);
			liste.add(dto);
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
    
    private IDAOMarque DAOMarque;
    
    private IDAOSpecialisationProduit DAOSpecialisationProduit;
    
    private IDAOTypeProduit DAOTypeProduit;
    
    

    
    
    

	public IDAOProduit getDAOProduit() {
		return DAOProduit;
	}


	public void setDAOProduit(IDAOProduit dAOProduit) {
		DAOProduit = dAOProduit;
	}


	public IDAOCommande getDAOCommande() {
		return DAOCommande;
	}


	public void setDAOCommande(IDAOCommande dAOCommande) {
		DAOCommande = dAOCommande;
	}


	public IDAOAvisClient getDAOAvisClient() {
		return DAOAvisClient;
	}


	public void setDAOAvisClient(IDAOAvisClient dAOAvisClient) {
		DAOAvisClient = dAOAvisClient;
	}


	public IDAOClient getDAOClient() {
		return DAOClient;
	}


	public void setDAOClient(IDAOClient dAOClient) {
		DAOClient = dAOClient;
	}


	public IDAOMarque getDAOMarque() {
		return DAOMarque;
	}


	public void setDAOMarque(IDAOMarque dAOMarque) {
		DAOMarque = dAOMarque;
	}


	public IDAOSpecialisationProduit getDAOSpecialisationProduit() {
		return DAOSpecialisationProduit;
	}


	public void setDAOSpecialisationProduit(IDAOSpecialisationProduit dAOSpecialisationProduit) {
		DAOSpecialisationProduit = dAOSpecialisationProduit;
	}


	public IDAOTypeProduit getDAOTypeProduit() {
		return DAOTypeProduit;
	}


	public void setDAOTypeProduit(IDAOTypeProduit dAOTypeProduit) {
		DAOTypeProduit = dAOTypeProduit;
	}
    
    
    

}