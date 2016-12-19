package fr.afcepf.al29.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.afcepf.al29.airguitare.api.IDAOAvisClient;
import fr.afcepf.al29.airguitare.api.IDAOClient;
import fr.afcepf.al29.airguitare.api.IDAOCommande;
import fr.afcepf.al29.airguitare.api.IDAOMarque;
import fr.afcepf.al29.airguitare.api.IDAOSpecialisationProduit;
import fr.afcepf.al29.airguitare.api.IDAOTypeProduit;
import fr.afcepf.al29.airguitare.dto.DTOMarque;
import fr.afcepf.al29.airguitare.dto.DTOProduit;
import fr.afcepf.al29.airguitare.dto.DTOSpecialisationProduit;
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
    @Path("listeAllProduits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getAllProduits() {
		return BUProduit.getAllProduits();
    }

	@GET
    @Path("listeAllMarques")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOMarque> getAllMarques() {
		return BUProduit.getAllMarque();
    }

	@GET
    @Path("listeAllSpecs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOSpecialisationProduit> getAllSpecs() {
		return BUProduit.getAllSpecs();
    }
	
	@GET
    @Path("listeProduitParOptions/{specs}/{marques}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getProduitParOptions(@PathParam("specs") String specialisations, @PathParam("marques") String marques) {
		return BUProduit.getProduitParOptions(specialisations, marques);
    }

	
	@GET
    @Path("produit/{ids}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduitById(@PathParam("ids") String param){
		DTOProduit dto = BUProduit.getProduitById(Integer.parseInt(param));
		 return Response.status(200).entity(dto).build();
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