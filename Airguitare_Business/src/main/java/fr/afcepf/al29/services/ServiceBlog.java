package fr.afcepf.al29.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.al29.airguitare.dto.DTOArticleBlog;
import fr.afcepf.al29.airguitare.entities.ArticleBlog;
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
		return buBlog.getAllArticle();
    }
	
	@GET
    @Path("nbComment/{nb}")
    @Produces(MediaType.APPLICATION_JSON)
	public Long nombreCommentaireByArticle(@PathParam("nb") int idArticle){
		System.out.println("coucou");
		return buBlog.nombreCommentaireByArticle(idArticle);
	}
	@GET
    @Path("singleArticle/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public DTOArticleBlog getArticleById(int idArticle){
		System.out.println(idArticle);
		return buBlog.getArticleByID(idArticle);
	}

}
