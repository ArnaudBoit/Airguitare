package fr.afcepf.al29.airguitare.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.afcepf.al29.airguitare.entities.Adresse;
import fr.afcepf.al29.airguitare.entities.AvisClient;
import fr.afcepf.al29.airguitare.entities.Commande;
import fr.afcepf.al29.airguitare.entities.CommentaireBlog;
import fr.afcepf.al29.airguitare.entities.ModePaiement;
import fr.afcepf.al29.airguitare.entities.Personne;

public class DTOPersonne{
	private int id;


	private String nom;

	private String prenom;

	private Date dateNaissance;

	private String adresseMail;

	private String telephone;

	private String password;

	private String statut;

	private List<DTOAvisClient> avisClients = new ArrayList<>();

	private List<DTOAdresse> adresses = new ArrayList<>();

	private List<DTOCommande> commandes = new ArrayList<>();

	private List<DTOModePaiement> modePaiements = new ArrayList<>();

	private List<DTOCommentaireBlog> commentaires = new ArrayList<>();


	public DTOPersonne() {
	}

	public DTOPersonne(Personne personne, boolean dependencies){
		this.setAdresseMail(personne.getAdresseMail());


		this.setDateNaissance(personne.getDateNaissance());
		this.setId(personne.getId());
		this.setNom(personne.getNom());
		this.setPassword(personne.getPassword());
		this.setPrenom(personne.getPrenom());
		this.setStatut(personne.getStatut());
		this.setTelephone(personne.getTelephone());

		if(dependencies){
			for (Adresse adresse : personne.getAdresses()) {
				this.getAdresses().add(new DTOAdresse(adresse,false));
			}
			for (ModePaiement mdepaiement : personne.getModePaiements()) {
				this.getModePaiements().add(new DTOModePaiement(mdepaiement,false));
			}

			for (CommentaireBlog com : personne.getCommentaires()) {
				this.getCommentaires().add(new DTOCommentaireBlog(com, false));
			}

			for (Commande com : personne.getCommandes()) {
				this.getCommandes().add(new DTOCommande(com,false));
			}

			for (AvisClient avis : personne.getAvisClients()) {
				this.getAvisClients().add(new DTOAvisClient(avis,false));
			}

			for (Commande commande : personne.getCommandes()) {
				this.getCommandes().add(new DTOCommande(commande,false));
			}

		}
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

	public List<DTOAvisClient> getAvisClients() {
		return avisClients;
	}

	public void setAvisClients(List<DTOAvisClient> avisClients) {
		this.avisClients = avisClients;
	}

	public List<DTOAdresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<DTOAdresse> adresses) {
		this.adresses = adresses;
	}

	public List<DTOCommande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<DTOCommande> commandes) {
		this.commandes = commandes;
	}

	public List<DTOModePaiement> getModePaiements() {
		return modePaiements;
	}

	public void setModePaiements(List<DTOModePaiement> modePaiements) {
		this.modePaiements = modePaiements;
	}

	public List<DTOCommentaireBlog> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<DTOCommentaireBlog> commentaires) {
		this.commentaires = commentaires;
	}


}
