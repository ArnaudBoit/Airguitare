package fr.afcepf.al29.airguitare.dto;

import java.util.Date;

import fr.afcepf.al29.airguitare.entities.AvisClient;
import fr.afcepf.al29.airguitare.entities.Billeterie;
import fr.afcepf.al29.airguitare.entities.LigneCommande;

public class DTOBilleterie extends DTOProduit {

    private String refBilleterie;

    private String categorie;

    private Date date;
    
    public DTOBilleterie() {
    }

	public DTOBilleterie(Billeterie billeterie, boolean dependencies){
		
		this.setId(billeterie.getId());
		this.setDescription(billeterie.getDescription());
		this.setIntitule(billeterie.getIntitule());		
		this.setNbVues(billeterie.getNbVues());
		this.setPhoto(billeterie.getPhoto());
		this.setPrix(billeterie.getPrix());
		this.setReference(billeterie.getReference());
		this.setSeuil(billeterie.getSeuil());		
		this.setStock(billeterie.getStock());
		this.setCategorie(billeterie.getCategorie());
		this.setDate(billeterie.getDate());
		this.setRefBilleterie(billeterie.getRefBilleterie());
		if (dependencies) {
			this.setMarque(new DTOMarque(billeterie.getMarque(),false));
			this.setSpecialisationProduit(new DTOSpecialisationProduit(billeterie.getSpecialisationProduit(), false));
			for (AvisClient avisClient : billeterie.getAvisClients()) {
				this.getAvisClients().add(new DTOAvisClient(avisClient,false));
			}
			for (LigneCommande ligneCommande : billeterie.getLigneCommandes()) {
				this.getLigneCommandes().add(new DTOLigneCommande(ligneCommande,false));
			}
		}
	}

	public String getRefBilleterie() {
		return refBilleterie;
	}

	public void setRefBilleterie(String refBilleterie) {
		this.refBilleterie = refBilleterie;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
