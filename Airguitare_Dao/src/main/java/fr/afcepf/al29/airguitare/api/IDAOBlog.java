package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.ArticleBlog;

/**
 * 
 */

public interface IDAOBlog {

    /**
     * @param ArticleBlog article 
     * @return
     */
    public ArticleBlog createNewArticleBlog(ArticleBlog article);

    /**
     * @return
     */
    public List<ArticleBlog> GetAllArticleSortedByDate();

    /**
     * @param String filtre 
     * @param String valeur 
     * @return
     */
    public List<ArticleBlog> GetAllArticleSortedBy(String filtre, String valeur);

    /**
     * @param ArticleBlog article 
     * @return
     */
    public ArticleBlog updateArticleBlog(ArticleBlog article);

    /**
     * @param int idArticle 
     * @return
     */
    public void removeArticleBlog(ArticleBlog article);

	Long nombreCommentaireByArticle(int idArticle);

	ArticleBlog getArticleByID(int idArticle);


}