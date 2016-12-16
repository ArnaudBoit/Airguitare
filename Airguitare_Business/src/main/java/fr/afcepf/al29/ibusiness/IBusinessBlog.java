package fr.afcepf.al29.ibusiness;

import java.util.List;

import fr.afcepf.al29.airguitare.dto.DTOArticleBlog;

/**
 * 
 */
public interface IBusinessBlog {

	List<DTOArticleBlog> getAllArticle();

	Long nombreCommentaireByArticle(int idArticle);
}