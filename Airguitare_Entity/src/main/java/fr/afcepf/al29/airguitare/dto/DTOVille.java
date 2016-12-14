package fr.afcepf.al29.airguitare.dto;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.Adresse;
import fr.afcepf.al29.airguitare.entities.Pays;
import fr.afcepf.al29.airguitare.entities.Ville;

public class DTOVille {

	 private int id;

	    
	    private String nom;

	    private String codePostal;

	    private Pays pays;
	   
	    private List<DTOAdresse> adresses;
	    
	    public DTOVille() {
	    }

	public DTOVille(Ville ville, boolean dependencies){

		
		this.setCodePostal(ville.getCodePostal());
		this.setId(ville.getId());
		this.setNom(ville.getNom());
		this.setPays(ville.getPays());
		if(dependencies){
			for (Adresse adresse : ville.getAdresses()) {
				this.getAdresses().add(new DTOAdresse(adresse,false));
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

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public List<DTOAdresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<DTOAdresse> adresses) {
		this.adresses = adresses;
	}
	
}
