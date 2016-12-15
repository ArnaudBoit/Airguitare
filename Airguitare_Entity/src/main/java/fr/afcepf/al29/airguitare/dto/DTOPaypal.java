package fr.afcepf.al29.airguitare.dto;

import fr.afcepf.al29.airguitare.entities.Paypal;

public class DTOPaypal {

	private int id;

	private String intitule;

	private String mail;

	private DTOModePaiement modePaiement = new DTOModePaiement();

	public DTOPaypal() {
	}


	public DTOPaypal(Paypal paypal, boolean dependencies){
		this.setId(paypal.getId());
		this.setIntitule(paypal.getIntitule());
		this.setMail(paypal.getMail());
		if(paypal.getModePaiement() != null) {
			this.setModePaiement(new DTOModePaiement(paypal.getModePaiement(),false));
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


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public DTOModePaiement getModePaiement() {
		return modePaiement;
	}


	public void setModePaiement(DTOModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}


}
