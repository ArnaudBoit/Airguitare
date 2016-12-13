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
@Table(name="typeProduit")
public class TypeProduit implements Serializable{

    
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
    @OneToMany(mappedBy="typeProduit")
    private Set<SpecialisationProduit> specialisationProduits;
    
    /**
     * Default constructor
     */
    public TypeProduit() {
    }

	public TypeProduit(int id, String intitule, Set<SpecialisationProduit> specialisationProduits) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.specialisationProduits = specialisationProduits;
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

	public Set<SpecialisationProduit> getSpecialisationProduits() {
		return specialisationProduits;
	}

	public void setSpecialisationProduits(Set<SpecialisationProduit> specialisationProduits) {
		this.specialisationProduits = specialisationProduits;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
    

}