package fr.afcepf.al29.airguitare.dto;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.CB;
import fr.afcepf.al29.airguitare.entities.Commande;
import fr.afcepf.al29.airguitare.entities.ModePaiement;

public class DTOModePaiement {
	private int id;

    private DTOPersonne personne;

    private List<DTOCommande> commandes;

    private DTOPaypal paypal;

    private List<DTOCB> cbs;
    
    public DTOModePaiement() {
    }
	public DTOModePaiement(ModePaiement modePaiement, boolean dependencies){
		
		this.setId(modePaiement.getId());
		
		if(dependencies){
			for (CB cb : modePaiement.getCbs()) {
				this.getCbs().add(new DTOCB(cb, false));
			}
			for (Commande com : modePaiement.getCommandes()) {
				this.getCommandes().add(new DTOCommande(com, false));
			}
			this.setPaypal(new DTOPaypal(modePaiement.getPaypal(),false));
		this.setPersonne(new DTOPersonne(modePaiement.getPersonne(), false) );
		}
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DTOPersonne getPersonne() {
		return personne;
	}
	public void setPersonne(DTOPersonne personne) {
		this.personne = personne;
	}
	public List<DTOCommande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<DTOCommande> commandes) {
		this.commandes = commandes;
	}
	public DTOPaypal getPaypal() {
		return paypal;
	}
	public void setPaypal(DTOPaypal paypal) {
		this.paypal = paypal;
	}
	public List<DTOCB> getCbs() {
		return cbs;
	}
	public void setCbs(List<DTOCB> cbs) {
		this.cbs = cbs;
	}
	
	
	
}
