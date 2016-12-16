package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOBlog;
import fr.afcepf.al29.airguitare.entities.ArticleBlog;

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
		Query query = em.createQuery("SELECT a FROM ArticleBlog a ORDER BY a.dateAjout");
		return query.getResultList();
	}

	@Override
	public Long nombreCommentaireByArticle(int idArticle){
		Query query = em.createQuery("SELECT COUNT(c) FROM CommentaireBlog c WHERE c.article.id = :idArticle").setParameter("idArticle", idArticle);
		
		return (Long) query.getSingleResult();
	}
}