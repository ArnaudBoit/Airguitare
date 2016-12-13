package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="commande")
public class Commande implements Serializable{

   

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
    private String numero;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private String statut;

    /**
     * 
     */
    @ManyToOne
    private Personne personne;

    /**
     * 
     */
    @OneToMany(mappedBy="commande")
    private List<LigneCommande> ligneCommandes;

    /**
     * 
     */
    @OneToOne(mappedBy="commande")
    private ModeLivraison modeLivraison;

    /**
     * 
     */
    @ManyToOne
    private ModePaiement modePaiement;
    
    /**
     * Default constructor
     */
    public Commande() {
    }

	public Commande(int id, String numero, Date date, String statut, Personne personne,
			List<LigneCommande> ligneCommandes, ModeLivraison modeLivraison, ModePaiement modePaiement) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.statut = statut;
		this.personne = personne;
		this.ligneCommandes = ligneCommandes;
		this.modeLivraison = modeLivraison;
		this.modePaiement = modePaiement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public ModeLivraison getModeLivraison() {
		return modeLivraison;
	}

	public void setModeLivraison(ModeLivraison modeLivraison) {
		this.modeLivraison = modeLivraison;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}
    
    

}