package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Set;

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
    private Set<Commande> commandes;

    /**
     * 
     */
    @OneToOne(mappedBy="modePaiement")
    private Paypal paypal;

    /**
     * 
     */
    @OneToMany(mappedBy="modePaiement")
    private Set<CB> cbs;
    
    /**
     * Default constructor
     */
    public ModePaiement() {
    }

	public ModePaiement(int id, Personne personne, Set<Commande> commandes, Paypal paypal, Set<CB> cbs) {
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

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Paypal getPaypal() {
		return paypal;
	}

	public void setPaypal(Paypal paypal) {
		this.paypal = paypal;
	}

	public Set<CB> getCbs() {
		return cbs;
	}

	public void setCbs(Set<CB> cbs) {
		this.cbs = cbs;
	}
    
    

}