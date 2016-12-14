package fr.afcepf.al29.airguitare.dto;

import java.util.Date;

import fr.afcepf.al29.airguitare.entities.CB;

public class DTOCB {
	private int id;

	private String identite;

	private String intitule;

	private String numero;

	private Date dateExpiration;

	private int cle;

	private DTOModePaiement modePaiement;

	public DTOCB() {
	}


	public DTOCB(CB cb, boolean dependencies){
		this.setId(cb.getId());
		this.setIdentite(cb.getIdentite());
		this.setIntitule(cb.getIntitule());
		this.setCle(cb.getCle());
		this.setDateExpiration(cb.getDateExpiration());		
		this.setNumero(cb.getNumero());
		if(dependencies){
			this.setModePaiement(new DTOModePaiement(cb.getModePaiement(),false));
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIdentite() {
		return identite;
	}


	public void setIdentite(String identite) {
		this.identite = identite;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Date getDateExpiration() {
		return dateExpiration;
	}


	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}


	public int getCle() {
		return cle;
	}


	public void setCle(int cle) {
		this.cle = cle;
	}


	public DTOModePaiement getModePaiement() {
		return modePaiement;
	}


	public void setModePaiement(DTOModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

}
