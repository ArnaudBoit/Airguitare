package fr.afcepf.al29.airguitare.dto;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.Formation;
import fr.afcepf.al29.airguitare.entities.Formule;

public class DTOFormule {
	  	private int id;

	    private String intitule;

	    private Integer nbHeures;

	    private List<DTOFormation> formations;
	    
	    public DTOFormule() {
	    }
	
	public DTOFormule(Formule formule, boolean dependencies){
		
		this.setId(formule.getId());
		this.setIntitule(formule.getIntitule());
		this.setNbHeures(formule.getNbHeures());
		
		if(dependencies){
			for (Formation formation : formule.getFormations()) {
				this.getFormations().add(new DTOFormation(formation, false));
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

	public Integer getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(Integer nbHeures) {
		this.nbHeures = nbHeures;
	}

	public List<DTOFormation> getFormations() {
		return formations;
	}

	public void setFormations(List<DTOFormation> formations) {
		this.formations = formations;
	}
	
	
	
}
