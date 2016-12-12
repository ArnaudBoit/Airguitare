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
@Table(name="avisClient")
public class AvisClient implements Serializable {
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
    private Integer note;

    /**
     * 
     */
    private String commentaire;

    /**
     * 
     */
    @ManyToOne
    private Produit produit;

    /**
     * 
     */
    @ManyToOne
    private Personne personne;
    
    /**
     * Default constructor
     */
    public AvisClient() {
    }
    
    

    public AvisClient(int id, Integer note, String commentaire, Produit produit, Personne personne) {
		super();
		this.id = id;
		this.note = note;
		this.commentaire = commentaire;
		this.produit = produit;
		this.personne = personne;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Integer getNote() {
		return note;
	}



	public void setNote(Integer note) {
		this.note = note;
	}



	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	public Produit getProduit() {
		return produit;
	}



	public void setProduit(Produit produit) {
		this.produit = produit;
	}



	public Personne getPersonne() {
		return personne;
	}



	public void setPersonne(Personne personne) {
		this.personne = personne;
	}


}