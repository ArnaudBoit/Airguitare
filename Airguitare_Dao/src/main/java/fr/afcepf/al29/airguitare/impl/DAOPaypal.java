package fr.afcepf.al29.airguitare.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOPaypal;
import fr.afcepf.al29.airguitare.entities.Paypal;

@Stateless
public class DAOPaypal implements IDAOPaypal {
	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;

	@Override
	public Paypal getPaypalByCLient(int idClient) {
		Query query = em.createQuery("FROM Paypal WHERE modePaiement.personne.id = :idClient").setParameter("idClient", idClient);
		return (Paypal) query.getSingleResult();
	}

}
