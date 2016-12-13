package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    
    private Date dateAjout;

    /**
     * 
     */
    @ManyToMany(mappedBy="articles")
    private List<ThemeArticle> themes;
    
    /**
     * 
     */
    @OneToMany(mappedBy="article")
    @Column(nullable=true)
    private List<CommentaireBlog> commentaires;
    
    /**
     * Default constructor
     */
    
    public ArticleBlog() {
    }
    
	public ArticleBlog(String intitule, String description, Date dateAjout, List<ThemeArticle> themes,
			List<CommentaireBlog> commentaires) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.dateAjout = dateAjout;
		this.themes = themes;
		this.commentaires = commentaires;
	}

	

	public ArticleBlog(int id, String intitule, String description, Date dateAjout, List<ThemeArticle> themes,
			List<CommentaireBlog> commentaires) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.description = description;
		this.dateAjout = dateAjout;
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





	public Date getDateAjout() {
		return dateAjout;
	}





	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}





	public List<ThemeArticle> getThemes() {
		return themes;
	}





	public void setThemes(List<ThemeArticle> themes) {
		this.themes = themes;
	}





	public List<CommentaireBlog> getCommentaires() {
		return commentaires;
	}





	public void setCommentaires(List<CommentaireBlog> commentaires) {
		this.commentaires = commentaires;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	

	
}