package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private List<AvisClient> avisClients;

    /**
     * 
     */
    @ManyToMany
    private List<Adresse> adresses;

    /**
     * 
     */
    @OneToMany(mappedBy="personne")
    private List<Commande> commandes;

    /**
     * 
     */
    @OneToMany(mappedBy="personne")
    private List<ModePaiement> modePaiements;

    /**
     * 
     */
    @OneToMany(mappedBy="personne")
    private List<CommentaireBlog> commentaires;
    
    /**
     * Default constructor
     */
    public Personne() {
    }

	public Personne(int id, String nom, String prenom, Date dateNaissance, String adresseMail, String telephone,
			String password, String statut, List<AvisClient> avisClients, List<Adresse> adresses, List<Commande> commandes,
			List<ModePaiement> modePaiements, List<CommentaireBlog> commentaires) {
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

	public List<AvisClient> getAvisClients() {
		return avisClients;
	}

	public void setAvisClients(List<AvisClient> avisClients) {
		this.avisClients = avisClients;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<ModePaiement> getModePaiements() {
		return modePaiements;
	}

	public void setModePaiements(List<ModePaiement> modePaiements) {
		this.modePaiements = modePaiements;
	}

	public List<CommentaireBlog> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<CommentaireBlog> commentaires) {
		this.commentaires = commentaires;
	}
    
    

}