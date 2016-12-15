package fr.afcepf.al29.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.al29.airguitare.api.IDAOAvisClient;
import fr.afcepf.al29.airguitare.api.IDAOClient;
import fr.afcepf.al29.airguitare.api.IDAOCommande;
import fr.afcepf.al29.airguitare.api.IDAOMarque;
import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.api.IDAOSpecialisationProduit;
import fr.afcepf.al29.airguitare.api.IDAOTypeProduit;
import fr.afcepf.al29.airguitare.dto.DTOProduit;
import fr.afcepf.al29.airguitare.entities.Produit;
import fr.afcepf.al29.business.BusinessProduit;
import fr.afcepf.al29.ibusiness.IBusinessProduit;


@Stateless
@Path("businessProduit")
public class ServiceProduit {
	
    private IBusinessProduit BUProduit;
	public ServiceProduit(){
		try {
			InitialContext initialContext = new InitialContext();
			BUProduit = (IBusinessProduit) initialContext.lookup("java:global/Airguitare_Ear-0.0.1-SNAPSHOT/Airguitare_Business/BusinessProduit!fr.afcepf.al29.ibusiness.IBusinessProduit");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	@GET
    @Path("listeProduits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getAllProduits() {
		return BUProduit.getAllProduits();
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