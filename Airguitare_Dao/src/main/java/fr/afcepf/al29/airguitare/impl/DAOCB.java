package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOCB;
import fr.afcepf.al29.airguitare.entities.CB;
@Stateless
public class DAOCB implements IDAOCB {
	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;
	@Override
	public List<CB> getCBByClient(int idClient) {
		Query query = em.createQuery("FROM CB WHERE modePaiement.personne.id = :idClient").setParameter("idClient", idClient);
		return query.getResultList();
	}

}
