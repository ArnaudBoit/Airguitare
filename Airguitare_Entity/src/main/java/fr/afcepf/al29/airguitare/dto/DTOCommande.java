package fr.afcepf.al29.airguitare.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.afcepf.al29.airguitare.entities.Commande;
import fr.afcepf.al29.airguitare.entities.LigneCommande;

public class DTOCommande {
	
	private int id;

    private String numero;

    private Date date;

    private String statut;

    private DTOPersonne personne = new DTOPersonne();

    private List<DTOLigneCommande> ligneCommandes = new ArrayList<>();

    private DTOModeLivraison modeLivraison = new DTOModeLivraison();

    private DTOModePaiement modePaiement = new DTOModePaiement();
    
    public DTOCommande() {
    }
	
	public DTOCommande(Commande commande, boolean dependencies){
		this.setDate(commande.getDate());
		this.setId(commande.getId());
		this.setStatut(commande.getStatut());
		this.setNumero(commande.getNumero());
		if(dependencies){
			if(commande.getPersonne() != null){
		this.setPersonne(new DTOPersonne(commande.getPersonne(), true) );
			}
		for (LigneCommande ligneCommande : commande.getLigneCommandes()) {
			this.getLigneCommandes().add(new DTOLigneCommande(ligneCommande,false));
		}
		if(commande.getModeLivraison() != null){
		this.setModeLivraison(new DTOModeLivraison(commande.getModeLivraison(),false));
		}
		if(commande.getModePaiement() != null){
		this.setModePaiement(new DTOModePaiement( commande.getModePaiement(),false));
		}
		}
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

	public DTOPersonne getPersonne() {
		return personne;
	}

	public void setPersonne(DTOPersonne personne) {
		this.personne = personne;
	}

	public List<DTOLigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<DTOLigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public DTOModeLivraison getModeLivraison() {
		return modeLivraison;
	}

	public void setModeLivraison(DTOModeLivraison modeLivraison) {
		this.modeLivraison = modeLivraison;
	}

	public DTOModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(DTOModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}
	
	
}
