package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * 
 */
@Entity
@DiscriminatorValue(value="Formation")
public class Formation extends Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String refFormation;

	/**
	 * 
	 */
	private Date dateDebut;

	/**
	 * 
	 */
	@ManyToMany(mappedBy="formations")
	@Column(nullable=true)
	private List<Formule> formules;



	/**
	 * Default constructor
	 */
	public Formation() {
	}



	


	public Formation(String refFormation, Date dateDebut, List<Formule> formules) {
		super();
		this.refFormation = refFormation;
		this.dateDebut = dateDebut;
		this.formules = formules;
	}






	public String getRefFormation() {
		return refFormation;
	}



	public void setRefFormation(String refFormation) {
		this.refFormation = refFormation;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public List<Formule> getFormules() {
		return formules;
	}


	public void setFormules(List<Formule> formules) {
		this.formules = formules;
	}



	

}