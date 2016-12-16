package fr.afcepf.al29.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.afcepf.al29.airguitare.dto.DTOArticleBlog;
import fr.afcepf.al29.ibusiness.IBusinessBlog;

@Stateless
@Path("businessBlog")
public class ServiceBlog {
	
	private IBusinessBlog buBlog;

	public ServiceBlog() {
		try {
			InitialContext initialContext = new InitialContext();
			buBlog = (IBusinessBlog) initialContext.lookup("java:global/Airguitare_Ear-0.0.1-SNAPSHOT/Airguitare_Business/BusinessBlog!fr.afcepf.al29.ibusiness.IBusinessBlog");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@GET
    @Path("listeArticles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOArticleBlog> getAllProduits() {
		System.out.println("nb articles =" + buBlog.getAllArticle().size());
		return buBlog.getAllArticle();
    }
	
	@GET
    @Path("nbComment")
    @Produces(MediaType.APPLICATION_JSON)
	public Long nombreCommentaireByArticle(@QueryParam("nb") int idArticle){
		return buBlog.nombreCommentaireByArticle(idArticle);
	}
	

}
