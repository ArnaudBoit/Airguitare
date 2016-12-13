package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.List;

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
@Table(name="specialisationProduit")
public class SpecialisationProduit implements Serializable{


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
    @ManyToOne
    private TypeProduit typeProduit;
    
    @OneToMany(mappedBy="specialisationProduit")
    private List<Produit> produits;

    /**
     * Default constructor
     */
    public SpecialisationProduit() {
    }


	

	public SpecialisationProduit(int id, String intitule, TypeProduit typeProduit, List<Produit> produits) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.typeProduit = typeProduit;
		this.produits = produits;
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


	public TypeProduit getTypeProduit() {
		return typeProduit;
	}


	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}




	public List<Produit> getProduits() {
		return produits;
	}




	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}