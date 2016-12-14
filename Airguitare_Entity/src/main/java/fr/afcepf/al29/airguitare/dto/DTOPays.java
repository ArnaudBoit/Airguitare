package fr.afcepf.al29.airguitare.dto;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.Pays;
import fr.afcepf.al29.airguitare.entities.Ville;

public class DTOPays {
	
	private int id;

    private String nom;

   
    private List<DTOVille> villes;
    
    public DTOPays() {
    }
	
	
	public DTOPays(Pays pays, boolean dependencies){
		this.setId(pays.getId());
		this.setNom(pays.getNom());
		
		if(dependencies){
		for (Ville ville : pays.getVilles()) {
			this.getVilles().add(new DTOVille(ville,false));
		}
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


	public List<DTOVille> getVilles() {
		return villes;
	}


	public void setVilles(List<DTOVille> villes) {
		this.villes = villes;
	}

	
	
}
