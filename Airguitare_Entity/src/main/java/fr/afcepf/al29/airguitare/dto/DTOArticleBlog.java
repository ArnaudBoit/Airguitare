package fr.afcepf.al29.airguitare.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.afcepf.al29.airguitare.entities.ArticleBlog;
import fr.afcepf.al29.airguitare.entities.CommentaireBlog;
import fr.afcepf.al29.airguitare.entities.ThemeArticle;

public class DTOArticleBlog {

	private int id;

	private String intitule;

	private String description;

	private Date dateAjout;
	
	private String photo;

	private List<DTOThemeArticle> themes = new ArrayList<>();

	private List<DTOCommentaireBlog> commentaires = new ArrayList<>();


	public DTOArticleBlog() {
	}

	public DTOArticleBlog(ArticleBlog articleBlog, boolean dependencies){
		this.setId(articleBlog.getId());
		this.setIntitule(articleBlog.getIntitule());
		this.setDescription(articleBlog.getDescription());
		this.setDateAjout(articleBlog.getDateAjout());
		this.setPhoto(articleBlog.getPhoto());

		if(dependencies){

			for (CommentaireBlog commentaireBlog : articleBlog.getCommentaires()) {
				this.getCommentaires().add(new DTOCommentaireBlog(commentaireBlog,true));
			}
			for (ThemeArticle themes : articleBlog.getThemes()) {
				this.getThemes().add(new DTOThemeArticle(themes, false) );
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
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	public List<DTOThemeArticle> getThemes() {
		return themes;
	}
	public void setThemes(List<DTOThemeArticle> themes) {
		this.themes = themes;
	}
	public List<DTOCommentaireBlog> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<DTOCommentaireBlog> commentaires) {
		this.commentaires = commentaires;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


}
