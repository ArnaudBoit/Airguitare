package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="ville")
public class Ville implements Serializable{
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
    private String nom;

    /**
     * 
     */
    private String codePostal;


    /**
     * 
     */
    @ManyToOne
    private Pays pays;
    
    @OneToMany(mappedBy="ville")
    private Set<Adresse> adresses;
    
    /**
     * Default constructor
     */
    public Ville() {
    }

	

	public Ville(int id, String nom, String codePostal, Pays pays, Set<Adresse> adresses) {
		super();
		this.id = id;
		this.nom = nom;
		this.codePostal = codePostal;
		this.pays = pays;
		this.adresses = adresses;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}



	public Set<Adresse> getAdresses() {
		return adresses;
	}



	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}
    
    

}