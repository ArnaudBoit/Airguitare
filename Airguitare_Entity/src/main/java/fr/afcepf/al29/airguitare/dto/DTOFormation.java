package fr.afcepf.al29.airguitare.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.afcepf.al29.airguitare.entities.AvisClient;
import fr.afcepf.al29.airguitare.entities.Formation;
import fr.afcepf.al29.airguitare.entities.Formule;
import fr.afcepf.al29.airguitare.entities.LigneCommande;

public class DTOFormation extends DTOProduit{

	private String refFormation;

	private Date dateDebut;

	private List<DTOFormule> formules = new ArrayList<>();

	public DTOFormation(Formation formation, boolean dependencies){
		this.setId(formation.getId());
		this.setDescription(formation.getDescription());
		this.setIntitule(formation.getIntitule());
		this.setRefFormation(formation.getRefFormation());
		this.setNbVues(formation.getNbVues());
		this.setPhoto(formation.getPhoto());
		this.setPrix(formation.getPrix());
		this.setReference(formation.getReference());
		this.setSeuil(formation.getSeuil());
		this.setStock(formation.getStock());
		this.setDateDebut(formation.getDateDebut());

		if(dependencies){

			for (Formule formule : formation.getFormules()) {
				this.getFormules().add(new DTOFormule(formule,false));
			}

			if(formation.getMarque() != null){
				this.setMarque(new DTOMarque(formation.getMarque(),false));
			}
			if(formation.getSpecialisationProduit()!=null){
				this.setSpecialisationProduit(new DTOSpecialisationProduit(formation.getSpecialisationProduit(), false));
			}
			for (AvisClient avisClient : formation.getAvisClients()) {
				this.getAvisClients().add(new DTOAvisClient(avisClient,false));
			}
			for (LigneCommande ligneCommande : formation.getLigneCommandes()) {
				this.getLigneCommandes().add(new DTOLigneCommande(ligneCommande,false));
			}
		}

	}

	public String getRefFormation() {
		return refFormation;
	}

	public void setRefFormation(String refFormation) {
		this.refFormation = refFormation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public List<DTOFormule> getFormules() {
		return formules;
	}

	public void setFormules(List<DTOFormule> formules) {
		this.formules = formules;
	}


}
