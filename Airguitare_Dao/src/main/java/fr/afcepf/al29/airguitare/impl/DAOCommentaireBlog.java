package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import fr.afcepf.al29.airguitare.api.IDAOCommentaireBlog;
import fr.afcepf.al29.airguitare.entities.ArticleBlog;
import fr.afcepf.al29.airguitare.entities.CommentaireBlog;
import fr.afcepf.al29.airguitare.entities.Personne;

/**
 * 
 */
public class DAOCommentaireBlog implements IDAOCommentaireBlog {

	@Override
	public void createNewCommentaireBlog(Personne client, CommentaireBlog commentaire, ArticleBlog article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCommentaire(int idCommentaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CommentaireBlog> getAllCommentaireByClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentaireBlog> getAllCommentaireByArticle(int idArticle) {
		// TODO Auto-generated method stub
		return null;
	}

   
}