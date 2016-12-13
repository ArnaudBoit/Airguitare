package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
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
@Table(name="modePaiement")
public class ModePaiement implements Serializable{

   

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
	@ManyToOne
    private Personne personne;

    /**
     * 
     */
    @OneToMany(mappedBy="modePaiement")
    private List<Commande> commandes;

    /**
     * 
     */
    @OneToOne(mappedBy="modePaiement")
    private Paypal paypal;

    /**
     * 
     */
    @OneToMany(mappedBy="modePaiement")
    private List<CB> cbs;
    
    /**
     * Default constructor
     */
    public ModePaiement() {
    }

	public ModePaiement(int id, Personne personne, List<Commande> commandes, Paypal paypal, List<CB> cbs) {
		super();
		this.id = id;
		this.personne = personne;
		this.commandes = commandes;
		this.paypal = paypal;
		this.cbs = cbs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Paypal getPaypal() {
		return paypal;
	}

	public void setPaypal(Paypal paypal) {
		this.paypal = paypal;
	}

	public List<CB> getCbs() {
		return cbs;
	}

	public void setCbs(List<CB> cbs) {
		this.cbs = cbs;
	}
    
    

}