package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="modeLivraison")
public class ModeLivraison implements Serializable{

   

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
    private Float tarif;

    /**
     * 
     */
    private int delai;

    /**
     * 
     */
    @OneToOne
    private Commande commande;
    
    /**
     * Default constructor
     */
    public ModeLivraison() {
    }

	public ModeLivraison(int id, String nom, Float tarif, int delai, Commande commande) {
		super();
		this.id = id;
		this.nom = nom;
		this.tarif = tarif;
		this.delai = delai;
		this.commande = commande;
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

	public Float getTarif() {
		return tarif;
	}

	public void setTarif(Float tarif) {
		this.tarif = tarif;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
    
    

}