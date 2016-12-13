package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="themeArticle")
public class ThemeArticle implements Serializable{

    

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    /**
     * 
     */
    private String intitule;

    /**
     * 
     */
    @ManyToMany
    private List<ArticleBlog> articles;
    
    /**
     * Default constructor
     */
    public ThemeArticle() {
    }

	public ThemeArticle(int id, String intitule, List<ArticleBlog> articles) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.articles = articles;
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

	public List<ArticleBlog> getArticle() {
		return articles;
	}

	public void setArticle(List<ArticleBlog> articles) {
		this.articles = articles;
	}
    
    

}