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
@Table(name="ligneCommande")
public class LigneCommande implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    /**
     * 
     */
    private int quantite;

    /**
     * 
     */
    @ManyToOne
    private Produit produit;

    /**
     * 
     */
    @ManyToOne
    private Commande commande;

    /**
     * Default constructor
     */
    public LigneCommande() {
    }

	public LigneCommande(int id, int quantite, Produit produit, Commande commande) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.produit = produit;
		this.commande = commande;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	
    

}