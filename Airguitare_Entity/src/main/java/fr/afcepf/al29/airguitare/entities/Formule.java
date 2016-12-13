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
@Table(name="formule")
public class Formule implements Serializable{

   

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
    private Integer nbHeures;

    /**
     * 
     */
    @ManyToMany
    private List<Formation> formations;
    
    /**
     * Default constructor
     */
    public Formule() {
    }

	public Formule(int id, String intitule, Integer nbHeures, List<Formation> formations) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.nbHeures = nbHeures;
		this.formations = formations;
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

	public Integer getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(Integer nbHeures) {
		this.nbHeures = nbHeures;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
    
    

}