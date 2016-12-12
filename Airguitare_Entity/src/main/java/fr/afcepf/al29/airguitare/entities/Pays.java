package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="pays")
public class Pays implements Serializable{

   
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
    @OneToMany(mappedBy="pays")
    private Set<Ville> villes;
    
    /**
     * Default constructor
     */
    public Pays() {
    }


	public Pays(int id, String nom, Set<Ville> villes) {
		super();
		this.id = id;
		this.nom = nom;
		this.villes = villes;
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


	public Set<Ville> getVilles() {
		return villes;
	}


	public void setVilles(Set<Ville> villes) {
		this.villes = villes;
	}
	
	
    
    

}