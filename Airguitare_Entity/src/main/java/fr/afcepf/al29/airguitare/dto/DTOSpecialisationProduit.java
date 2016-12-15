package fr.afcepf.al29.airguitare.dto;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al29.airguitare.entities.Produit;
import fr.afcepf.al29.airguitare.entities.SpecialisationProduit;

public class DTOSpecialisationProduit {

	private int id;

	private String intitule;

	private DTOTypeProduit typeProduit = new DTOTypeProduit();

	private List<DTOProduit> produits = new ArrayList<>();

	public DTOSpecialisationProduit() {

	}


	public DTOSpecialisationProduit(SpecialisationProduit specialisationProduit, boolean dependencies){

		this.setId(specialisationProduit.getId());
		this.setIntitule(specialisationProduit.getIntitule());

		if(dependencies){
			for (Produit produit : specialisationProduit.getProduits()) {
				this.getProduits().add(new DTOProduit(produit,false));
			}

			if(specialisationProduit.getTypeProduit() != null) {
				this.setTypeProduit(new DTOTypeProduit(specialisationProduit.getTypeProduit(),false));
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


	public DTOTypeProduit getTypeProduit() {
		return typeProduit;
	}


	public void setTypeProduit(DTOTypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}


	public List<DTOProduit> getProduits() {
		return produits;
	}


	public void setProduits(List<DTOProduit> produits) {
		this.produits = produits;
	}


}
