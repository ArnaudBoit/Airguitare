package fr.afcepf.al29.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.afcepf.al29.airguitare.api.IDAOClient;
import fr.afcepf.al29.airguitare.api.IDAOCommande;
import fr.afcepf.al29.airguitare.api.IDAOLigneCommande;
import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.dto.DTOCommande;
import fr.afcepf.al29.airguitare.dto.DTOLigneCommande;
import fr.afcepf.al29.airguitare.dto.DTOProduit;
import fr.afcepf.al29.airguitare.entities.Commande;
import fr.afcepf.al29.airguitare.entities.LigneCommande;
import fr.afcepf.al29.airguitare.entities.ModeLivraison;
import fr.afcepf.al29.business.BusinessCommande;
import fr.afcepf.al29.ibusiness.IBusinessCommande;
import fr.afcepf.al29.ibusiness.IBusinessProduit;
import fr.afcepf.al29.ibusiness.IBusinessUtilisateur;

@Stateless
@Path("commandes")
public class ServiceCommande {
	
	@EJB
	private IBusinessCommande buCommande;
	@EJB
	private IDAOClient daoPersonne;
	@EJB
	private IDAOProduit daoProduit;
	@EJB
	private IDAOCommande daocommande;
	@EJB
	private IDAOLigneCommande daoLigne;
	@EJB
	private IBusinessUtilisateur buPersonne;
	
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
		return buCommande.getPrixByCommande(Integer.parseInt(param.id));
		
	}
	
	@PUT
	@Path("order")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveCommande(PanierParam panier){
	
			Commande commande = new Commande();
			System.out.println(panier.idPers);
			commande.setPersonne(daoPersonne.getClientById(panier.idPers));
			commande.setDate(new Date());
			commande.setModeLivraison(null);
			commande.setNumero("CMD" + panier.idPers +"Test");
			commande.setLigneCommandes(new ArrayList<>());
			Commande com = daocommande.addCommande(commande);
			
			for (LigneComParam ligne : panier.Panier) {
				LigneCommande ligneCom = new LigneCommande();
				ligneCom.setCommande(com);
				
				ligneCom.setProduit(daoProduit.getArticleById(ligne.id));
				ligneCom.setQuantite(ligne.quantite);
				LigneCommande ln = daoLigne.addLigne(ligneCom);
				com.getLigneCommandes().add(ln);
				daocommande.updateCommande(com);
			}
			return Response.status(200).build();

		
	}
	
}
