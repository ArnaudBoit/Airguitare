package fr.afcepf.al29.airguitare.api;

import javax.ejb.Local;

import fr.afcepf.al29.airguitare.entities.Paypal;
@Local
public interface IDAOPaypal {
	
	Paypal getPaypalByCLient(int idClient);

}
