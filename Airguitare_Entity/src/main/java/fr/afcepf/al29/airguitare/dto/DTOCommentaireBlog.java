package fr.afcepf.al29.airguitare.dto;

import fr.afcepf.al29.airguitare.entities.CommentaireBlog;

public class DTOCommentaireBlog {
	 	private int id;

	    private String intitule;

	    private String description;

	    private DTOPersonne personne = new DTOPersonne();

	    private DTOArticleBlog article = new DTOArticleBlog();
	    
	    public DTOCommentaireBlog() {
	    }
	    
		
	public DTOCommentaireBlog(CommentaireBlog commentaireBlog, boolean dependencies){
		
		this.setDescription(commentaireBlog.getDescription());
		this.setId(commentaireBlog.getId());
		this.setIntitule(commentaireBlog.getIntitule());
		if(dependencies){
		if(commentaireBlog.getPersonne()!= null){
			this.setPersonne(new DTOPersonne(commentaireBlog.getPersonne(),false));
		}
		if(commentaireBlog.getArticle()!= null){
		this.setArticle(new DTOArticleBlog( commentaireBlog.getArticle(),false));
		}
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public DTOPersonne getPersonne() {
		return personne;
	}


	public void setPersonne(DTOPersonne personne) {
		this.personne = personne;
	}


	public DTOArticleBlog getArticle() {
		return article;
	}


	public void setArticle(DTOArticleBlog article) {
		this.article = article;
	}

	
}
