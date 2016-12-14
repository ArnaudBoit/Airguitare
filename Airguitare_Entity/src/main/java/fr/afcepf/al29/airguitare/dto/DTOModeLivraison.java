package fr.afcepf.al29.airguitare.dto;

import fr.afcepf.al29.airguitare.entities.ModeLivraison;

public class DTOModeLivraison {
	private int id;

    private String nom;

    private Float tarif;

    private int delai;

    private DTOCommande commande;
    
    public DTOModeLivraison() {
    }
	public DTOModeLivraison(ModeLivraison modeLivraison, boolean dependencies){
		
		this.setDelai(modeLivraison.getDelai());
		this.setId(modeLivraison.getId());
		this.setNom(modeLivraison.getNom());
		this.setTarif(modeLivraison.getTarif());
		if(dependencies){
		this.setCommande(new DTOCommande(modeLivraison.getCommande(),false) );
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
	public Float getTarif() {
		return tarif;
	}
	public void setTarif(Float tarif) {
		this.tarif = tarif;
	}
	public int getDelai() {
		return delai;
	}
	public void setDelai(int delai) {
		this.delai = delai;
	}
	public DTOCommande getCommande() {
		return commande;
	}
	public void setCommande(DTOCommande commande) {
		this.commande = commande;
	}
	
	
	
}
