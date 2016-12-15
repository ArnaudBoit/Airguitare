package fr.afcepf.al29.airguitare.dto;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al29.airguitare.entities.ArticleBlog;
import fr.afcepf.al29.airguitare.entities.ThemeArticle;

public class DTOThemeArticle{

	private int id;

	private String intitule;

	private List<DTOArticleBlog> articles = new ArrayList<>();

	public DTOThemeArticle() {
	}

	public DTOThemeArticle(ThemeArticle themeArticle, boolean dependeci){
		this.setId(themeArticle.getId());
		this.setIntitule(themeArticle.getIntitule());
		for (ArticleBlog articleBlog : themeArticle.getArticle()) {
			this.getArticles().add(new DTOArticleBlog(articleBlog,false));
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

	public List<DTOArticleBlog> getArticles() {
		return articles;
	}

	public void setArticles(List<DTOArticleBlog> articles) {
		this.articles = articles;
	}


}
