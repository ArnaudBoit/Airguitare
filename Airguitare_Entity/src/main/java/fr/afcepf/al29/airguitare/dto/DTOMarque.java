package fr.afcepf.al29.airguitare.dto;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al29.airguitare.entities.Marque;
import fr.afcepf.al29.airguitare.entities.Produit;

public class DTOMarque {

	private int id;

	private String intitule;

	private String logo;

	private List<DTOProduit> produits= new ArrayList<>();;

	public DTOMarque() {

	}

	public DTOMarque(Marque marque, boolean dependencies) {
		this.setId(marque.getId());
		this.setIntitule(marque.getIntitule());
		this.setLogo(marque.getLogo());


		if (dependencies) {
			for (Produit produit : marque.getProduits()) {
				DTOProduit dto = new DTOProduit(produit,true);
				produits.add(dto);
			}
		}
		this.setProduits(produits);
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<DTOProduit> getProduits() {
		return produits;
	}

	public void setProduits(List<DTOProduit> produits) {
		this.produits = produits;
	}

}


