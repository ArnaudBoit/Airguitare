package fr.afcepf.al29.services;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.afcepf.al29.airguitare.dto.DTOPersonne;
import fr.afcepf.al29.ibusiness.IBusinessUtilisateur;

@Stateless
@Path("clients")
public class ServiceUtilisateur {
	
	private IBusinessUtilisateur buUtilisateur;
	
	public ServiceUtilisateur(){
		try {
			InitialContext initialContext = new InitialContext();
			buUtilisateur = (IBusinessUtilisateur) initialContext.lookup("java:global/Airguitare_Ear-0.0.1-SNAPSHOT/Airguitare_Business/BusinessUtilisateur!fr.afcepf.al29.ibusiness.IBusinessUtilisateur");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	@POST
    @Path("connect")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public Response connect(Credentials cred) {
		
		
		DTOPersonne pers = buUtilisateur.connectClient(cred.login, cred.password);
		if(pers!=null){
		return Response.status(201).entity(pers).build();
		}else{
		return Response.status(500).entity("utilisateur inconnu").build();
		}
	}
	
	
}
