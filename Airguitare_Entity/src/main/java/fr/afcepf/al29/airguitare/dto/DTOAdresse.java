package fr.afcepf.al29.airguitare.dto;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al29.airguitare.entities.Adresse;
import fr.afcepf.al29.airguitare.entities.Personne;
import fr.afcepf.al29.airguitare.entities.Ville;

public class DTOAdresse {
	
	private int id;

    private int numero;
    
    private String rue;

    private String complement;

    private List<DTOPersonne> personnes = new ArrayList<>();

    private DTOVille ville;
   
    public DTOAdresse() {
    }
    
    
	public DTOAdresse(Adresse adresse, boolean dependencies){
		
		this.setId(adresse.getId());
		this.setNumero(adresse.getNumero());
		this.setRue(adresse.getRue());
		this.setComplement(adresse.getComplement());
		if(dependencies){
			if (adresse.getVille()!=null){
		this.setVille(new DTOVille(adresse.getVille(),false));
			}
		for (Personne personne : adresse.getPersonnes()) {
			this.getPersonnes().add(new DTOPersonne(personne,false));
		}
		
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public List<DTOPersonne> getPersonnes() {
		return personnes;
	}


	public void setPersonnes(List<DTOPersonne> personnes) {
		this.personnes = personnes;
	}


	public DTOVille getVille() {
		return ville;
	}


	public void setVille(DTOVille ville) {
		this.ville = ville;
	}
	
	
}
