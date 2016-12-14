package fr.afcepf.al29.airguitare.dto;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.SpecialisationProduit;
import fr.afcepf.al29.airguitare.entities.TypeProduit;

public class DTOTypeProduit {

	private int id;

	private String intitule;


	private List<DTOSpecialisationProduit> specialisationProduits;

	public DTOTypeProduit() {
	}
	public DTOTypeProduit(TypeProduit typeProduit, boolean dependencies){

		this.setId(typeProduit.getId());
		this.setIntitule(typeProduit.getIntitule());

		if(dependencies){
			for (SpecialisationProduit specialisationProduit : typeProduit.getSpecialisationProduits()) {
				this.getSpecialisationProduits().add(new DTOSpecialisationProduit(specialisationProduit,false));
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
	public List<DTOSpecialisationProduit> getSpecialisationProduits() {
		return specialisationProduits;
	}
	public void setSpecialisationProduits(List<DTOSpecialisationProduit> specialisationProduits) {
		this.specialisationProduits = specialisationProduits;
	}


}
