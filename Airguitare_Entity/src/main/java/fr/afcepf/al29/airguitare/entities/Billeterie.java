package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 */
@Entity
@DiscriminatorValue(value="Billeterie")
public class Billeterie extends Produit implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	
    private String refBilleterie;

    /**
     * 
     */
    private String categorie;

    /**
     * 
     */
    private Date date;
    
    /**
     * Default constructor
     */
    public Billeterie() {
    }

	public Billeterie(String refBilleterie, String categorie, Date date) {
		super();
		this.refBilleterie = refBilleterie;
		this.categorie = categorie;
		this.date = date;
	}

	public String getRefBilleterie() {
		return refBilleterie;
	}

	public void setRefBilleterie(String refBilleterie) {
		this.refBilleterie = refBilleterie;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    

}