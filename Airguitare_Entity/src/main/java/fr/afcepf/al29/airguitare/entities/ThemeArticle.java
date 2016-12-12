package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Set;

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
    private Set<ArticleBlog> articles;
    
    /**
     * Default constructor
     */
    public ThemeArticle() {
    }

	public ThemeArticle(int id, String intitule, Set<ArticleBlog> articles) {
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

	public Set<ArticleBlog> getArticle() {
		return articles;
	}

	public void setArticle(Set<ArticleBlog> articles) {
		this.articles = articles;
	}
    
    

}