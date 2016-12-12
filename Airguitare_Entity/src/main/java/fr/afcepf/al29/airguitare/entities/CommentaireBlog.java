package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="commentaireBlog")
public class CommentaireBlog implements Serializable{

   

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
    private String description;

    /**
     * 
     */
    @ManyToOne
    private Personne personne;

    /**
     * 
     */
    @ManyToOne
    private ArticleBlog article;
    
    /**
     * Default constructor
     */
    public CommentaireBlog() {
    }

	public CommentaireBlog(int id, String intitule, String description, Personne personne, ArticleBlog article) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.description = description;
		this.personne = personne;
		this.article = article;
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

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public ArticleBlog getArticle() {
		return article;
	}

	public void setArticle(ArticleBlog article) {
		this.article = article;
	}
    
    

}