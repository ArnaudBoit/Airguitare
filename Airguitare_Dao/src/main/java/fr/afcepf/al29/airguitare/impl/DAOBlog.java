package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOBlog;
import fr.afcepf.al29.airguitare.entities.ArticleBlog;
import fr.afcepf.al29.airguitare.entities.CommentaireBlog;

/**
 * 
 */
@Stateless
public class DAOBlog implements IDAOBlog {

	@PersistenceContext(unitName="Airguitare_Dao")
    EntityManager em;

	@Override
	public ArticleBlog createNewArticleBlog(ArticleBlog article) {
		em.persist(article);
		return article;
	}

	@Override
	public List<ArticleBlog> GetAllArticleSortedBy(String filtre, String valeur) {
		
		return null;
	}

	@Override
	public ArticleBlog updateArticleBlog(ArticleBlog article) {
		em.merge(article);
		return article;
	}

	@Override
	public void removeArticleBlog(ArticleBlog article) {
		em.remove(article);
		
	}

	@Override
	public List<ArticleBlog> GetAllArticleSortedByDate() {
		Query query = em.createQuery("SELECT a FROM ArticleBlog a ORDER BY a.dateAjout DESC");
		return query.getResultList();
	}

	@Override
	public List<CommentaireBlog> nombreCommentaireByArticle(int idArticle){
		Query query = em.createQuery("Select c FROM CommentaireBlog c  WHERE c.article.id = :idArticle").setParameter("idArticle", idArticle);
		
		return   query.getResultList();
	}
	
	@Override
	public ArticleBlog getArticleByID(int idArticle){
		
		Query query = em.createQuery("SELECT a FROM ArticleBlog a WHERE a.id = :idArticle").setParameter("idArticle", idArticle);
		return (ArticleBlog) query.getSingleResult();
		
	}

	
}