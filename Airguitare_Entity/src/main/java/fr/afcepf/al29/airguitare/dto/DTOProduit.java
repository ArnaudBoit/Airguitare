package fr.afcepf.al29.airguitare.dto;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al29.airguitare.entities.AvisClient;
import fr.afcepf.al29.airguitare.entities.LigneCommande;
import fr.afcepf.al29.airguitare.entities.Produit;

public class DTOProduit {

	private int id;

	private String intitule;

	private String description;

	private Double prix;

	private String photo;

	private String reference;

	private Integer stock;

	private Integer seuil;

	private Integer nbVues;

	private DTOSpecialisationProduit specialisationProduit = new DTOSpecialisationProduit();

	private DTOMarque marque = new DTOMarque();

	private List<DTOLigneCommande> ligneCommandes = new ArrayList<>();

	private List<DTOAvisClient> avisClients = new ArrayList<>();

	public DTOProduit() {
	}

	public DTOProduit(Produit produit, boolean dependencies) {

		this.setId(produit.getId());
		this.setDescription(produit.getDescription());
		this.setReference(produit.getReference());
		this.setIntitule(produit.getIntitule());
		this.setNbVues(produit.getNbVues());
		this.setPhoto(produit.getPhoto());
		this.setSeuil(produit.getSeuil());
		this.setStock(produit.getStock());
		this.setPrix(produit.getPrix());

		if (dependencies) {
			if (produit.getMarque() != null) {
				this.setMarque(new DTOMarque(produit.getMarque(), false));
			}

			if(produit.getSpecialisationProduit() != null){
				this.setSpecialisationProduit(new DTOSpecialisationProduit(produit.getSpecialisationProduit(), false));
			}

			for (AvisClient avisClient : produit.getAvisClients()) {
				this.getAvisClients().add(new DTOAvisClient(avisClient, false));
			}

			for (LigneCommande ligneCommande : produit.getLigneCommandes()) {
				this.getLigneCommandes().add(new DTOLigneCommande(ligneCommande, false));
			}

		}
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSeuil() {
		return seuil;
	}

	public void setSeuil(Integer seuil) {
		this.seuil = seuil;
	}

	public Integer getNbVues() {
		return nbVues;
	}

	public void setNbVues(Integer nbVues) {
		this.nbVues = nbVues;
	}

	public DTOMarque getMarque() {
		return marque;
	}

	public void setMarque(DTOMarque marque) {
		this.marque = marque;
	}

	public DTOSpecialisationProduit getSpecialisationProduit() {
		return specialisationProduit;
	}

	public void setSpecialisationProduit(DTOSpecialisationProduit dtoSpecialisationProduit) {
		this.specialisationProduit = dtoSpecialisationProduit;
	}

	public List<DTOLigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<DTOLigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public List<DTOAvisClient> getAvisClients() {
		return avisClients;
	}

	public void setAvisClients(List<DTOAvisClient> avisClients) {
		this.avisClients = avisClients;
	}

}
