package fr.afcepf.al29.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.afcepf.al29.airguitare.api.IDAOCommande;
import fr.afcepf.al29.airguitare.dto.DTOCommande;
import fr.afcepf.al29.airguitare.dto.DTOLigneCommande;
import fr.afcepf.al29.airguitare.dto.DTOProduit;
import fr.afcepf.al29.business.BusinessCommande;
import fr.afcepf.al29.ibusiness.IBusinessCommande;

@Stateless
@Path("commandes")
public class ServiceCommande {
	
	private IBusinessCommande buCommande;
	private IDAOCommande daocommande;
	
	public ServiceCommande(){
		try {
			InitialContext initialContext = new InitialContext();
			buCommande = (IBusinessCommande) initialContext.lookup("java:global/Airguitare_Ear-0.0.1-SNAPSHOT/Airguitare_Business/BusinessCommande!fr.afcepf.al29.ibusiness.IBusinessCommande");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@POST
    @Path("byUserID")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public Response getCommandesByUserId(IdParam param) {
		
		
		List<DTOCommande> commandesDTO = buCommande.getCommandesByUser(Integer.parseInt(param.id));
		
		if(commandesDTO!=null){
			return Response.status(201).entity(commandesDTO).build();
			
			}else{
			return Response.status(500).entity("Aucune commande").build();
			}
	}
	
	@POST
    @Path("byCommandeID")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public double getPrixByCommande(IdParam param) {
		double prix =0;
		List<DTOLigneCommande> dtoligne = new ArrayList<>();
			prix=buCommande.getPrixByCommande(Integer.parseInt(param.id));
		List<DTOProduit> produits = new ArrayList<>();
		if(dtoligne != null){
			for (DTOLigneCommande dtoLigneCommande : dtoligne) {
				produits.add(dtoLigneCommande.getProduit());
				for (DTOProduit dtoProduit : produits) {
					
					prix += dtoProduit.getPrix();
				}
				
			}
		}
		
		return prix;
		
	}
	
	
}
