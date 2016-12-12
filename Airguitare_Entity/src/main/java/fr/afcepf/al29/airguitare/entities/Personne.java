package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */

@Entity
@Table(name="personne")
public class Personne implements Serializable{

   

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
    private String prenom;

    /**
     * 
     */
    private Date dateNaissance;

    /**
     * 
     */
    private String adresseMail;

    /**
     * 
     */
    private String telephone;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String statut;

    /**
     * 
     */
    @OneToMany(mappedBy="personne")
    private Set<AvisClient> avisClients;

    /**
     * 
     */
    @ManyToMany
    private Set<Adresse> adresses;

    /**
     * 
     */
    @OneToMany(mappedBy="personne")
    private Set<Commande> commandes;

    /**
     * 
     */
    @OneToMany(mappedBy="personne")
    private Set<ModePaiement> modePaiements;

    /**
     * 
     */
    @OneToMany(mappedBy="personne")
    private Set<CommentaireBlog> commentaires;
    
    /**
     * Default constructor
     */
    public Personne() {
    }

	public Personne(int id, String nom, String prenom, Date dateNaissance, String adresseMail, String telephone,
			String password, String statut, Set<AvisClient> avisClients, Set<Adresse> adresses, Set<Commande> commandes,
			Set<ModePaiement> modePaiements, Set<CommentaireBlog> commentaires) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresseMail = adresseMail;
		this.telephone = telephone;
		this.password = password;
		this.statut = statut;
		this.avisClients = avisClients;
		this.adresses = adresses;
		this.commandes = commandes;
		this.modePaiements = modePaiements;
		this.commentaires = commentaires;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Set<AvisClient> getAvisClients() {
		return avisClients;
	}

	public void setAvisClients(Set<AvisClient> avisClients) {
		this.avisClients = avisClients;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Set<ModePaiement> getModePaiements() {
		return modePaiements;
	}

	public void setModePaiements(Set<ModePaiement> modePaiements) {
		this.modePaiements = modePaiements;
	}

	public Set<CommentaireBlog> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<CommentaireBlog> commentaires) {
		this.commentaires = commentaires;
	}
    
    

}