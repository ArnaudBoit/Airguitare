package fr.afcepf.al29.ibusiness;

import java.util.List;

import fr.afcepf.al29.airguitare.dto.DTOArticleBlog;
import fr.afcepf.al29.airguitare.entities.ArticleBlog;

/**
 * 
 */
public interface IBusinessBlog {

	List<DTOArticleBlog> getAllArticle();

	Long nombreCommentaireByArticle(int idArticle);

	ArticleBlog getArticleById(int idArticle);
}