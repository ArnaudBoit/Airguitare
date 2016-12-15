package fr.afcepf.al29.airguitare.dto;

import fr.afcepf.al29.airguitare.entities.AvisClient;

public class DTOAvisClient {
	
	 private int id;

	    private Integer note;

	    private String commentaire;

	    private DTOProduit produit;

	    private DTOPersonne personne;
	    
	    public DTOAvisClient() {
	    }

	public DTOAvisClient(AvisClient avisClient, boolean dependencies) {
		this.setId(avisClient.getId());
		this.setNote(avisClient.getNote());
		this.setCommentaire(avisClient.getCommentaire());
		if(dependencies){
			if(avisClient.getPersonne() != null){
				this.setPersonne(new DTOPersonne(avisClient.getPersonne(),false));
			}
			if(avisClient.getProduit() != null) {
				this.setProduit(new DTOProduit(avisClient.getProduit(),false));
			}
		
		
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public DTOProduit getProduit() {
		return produit;
	}

	public void setProduit(DTOProduit produit) {
		this.produit = produit;
	}

	public DTOPersonne getPersonne() {
		return personne;
	}

	public void setPersonne(DTOPersonne personne) {
		this.personne = personne;
	}
	
	
}
