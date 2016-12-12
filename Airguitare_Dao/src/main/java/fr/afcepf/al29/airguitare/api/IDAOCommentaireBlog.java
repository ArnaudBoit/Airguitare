package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.ArticleBlog;
import fr.afcepf.al29.airguitare.entities.CommentaireBlog;
import fr.afcepf.al29.airguitare.entities.Personne;

/**
 * 
 */
public interface IDAOCommentaireBlog {

    /**
     * @param Personneclient 
     * @param CommentaireBlog commentaire 
     * @param ArticleBlog article 
     * @return
     */
    public void createNewCommentaireBlog(Personne client, CommentaireBlog commentaire, ArticleBlog article);

    /**
     * @param int idCommentaire 
     * @return
     */
    public void removeCommentaire(int idCommentaire);

    /**
     * @param int idClient 
     * @return
     */
    public List<CommentaireBlog> getAllCommentaireByClient(int idClient);

    /**
     * @param int idArticle 
     * @return
     */
    public List<CommentaireBlog> getAllCommentaireByArticle(int idArticle);

}