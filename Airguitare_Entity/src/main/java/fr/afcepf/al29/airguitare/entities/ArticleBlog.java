package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="articleBlog")
public class ArticleBlog implements Serializable {

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
    @ManyToMany(mappedBy="articles")
    private Set<ThemeArticle> themes;
    
    /**
     * 
     */
    @OneToMany(mappedBy="article")
    @Column(nullable=true)
    private Set<CommentaireBlog> commentaires;
    
    /**
     * Default constructor
     */
    
    public ArticleBlog() {
    }
    
    

    public ArticleBlog(int id, String intitule, String description, Set<ThemeArticle> themes,
			Set<CommentaireBlog> commentaires) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.description = description;
		this.themes = themes;
		this.commentaires = commentaires;
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



	public Set<ThemeArticle> getThemes() {
		return themes;
	}



	public void setThemes(Set<ThemeArticle> themes) {
		this.themes = themes;
	}



	public Set<CommentaireBlog> getCommentaires() {
		return commentaires;
	}



	public void setCommentaires(Set<CommentaireBlog> commentaires) {
		this.commentaires = commentaires;
	}

}