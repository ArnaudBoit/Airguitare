package fr.afcepf.al29.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.AttributeOverrides;

import fr.afcepf.al29.airguitare.api.IDAOArticleBlog;
import fr.afcepf.al29.airguitare.api.IDAOBlog;
import fr.afcepf.al29.airguitare.api.IDAOCommentaireBlog;
import fr.afcepf.al29.airguitare.api.IDAOThemeArticle;
import fr.afcepf.al29.airguitare.dto.DTOArticleBlog;
import fr.afcepf.al29.airguitare.entities.ArticleBlog;
import fr.afcepf.al29.ibusiness.IBusinessBlog;


/**
 * 
 */
@Stateless
public class BusinessBlog implements IBusinessBlog {

    /**
     * 
     */
	@EJB
    private IDAOBlog DAOBlog;

    /**
     * 
     */
    private IDAOCommentaireBlog DAOCommentaireBlog;
    
    /**
     * 
     */
    private IDAOArticleBlog DAOArticleBlog;
    
    private IDAOThemeArticle DAOThemeArticle;

	@Override
	public List<DTOArticleBlog> getAllArticle() {
		List<DTOArticleBlog> liste = new ArrayList<>();
			for (ArticleBlog article : DAOBlog.GetAllArticleSortedByDate()) {
				DTOArticleBlog dto  = new DTOArticleBlog(article, false);
				liste.add(dto);
			}
		return liste;
	}
	
	@Override
	public Long nombreCommentaireByArticle(int idArticle){
		System.out.println("bu " + DAOBlog.nombreCommentaireByArticle(idArticle));
		return DAOBlog.nombreCommentaireByArticle(idArticle);
	}
	
	@Override
	public DTOArticleBlog getArticleByID(int idArticle) {
		
		ArticleBlog article = new ArticleBlog();
		article= DAOBlog.getArticleByID(idArticle);
		if(article != null){
			DTOArticleBlog dto = new DTOArticleBlog(article,false);
			return dto;
		}
		
		return null;
		
		
	}

}