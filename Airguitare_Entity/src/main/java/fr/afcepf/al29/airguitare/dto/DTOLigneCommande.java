package fr.afcepf.al29.airguitare.dto;

import fr.afcepf.al29.airguitare.entities.LigneCommande;

public class DTOLigneCommande {
	private int id;

	private int quantite;

	private DTOProduit produit;

	private DTOCommande commande;

	public DTOLigneCommande() {
	}
	public DTOLigneCommande(LigneCommande ligneCommande, boolean dependencies){
		
		this.setId(ligneCommande.getId());
		this.setQuantite(ligneCommande.getQuantite());
		if(dependencies){
		this.setCommande(new DTOCommande(ligneCommande.getCommande(),false));
		this.setProduit(new DTOProduit(ligneCommande.getProduit(), true) );
		
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public DTOProduit getProduit() {
		return produit;
	}
	public void setProduit(DTOProduit produit) {
		this.produit = produit;
	}
	public DTOCommande getCommande() {
		return commande;
	}
	public void setCommande(DTOCommande commande) {
		this.commande = commande;
	}


}
