package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOSpecialisationProduit;
import fr.afcepf.al29.airguitare.entities.SpecialisationProduit;
import fr.afcepf.al29.airguitare.entities.TypeProduit;
@Stateless
public class DAOSpecialisationProduit implements IDAOSpecialisationProduit {

	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;
	@Override
	public List<SpecialisationProduit> getSpecialisationProduitByTypeProduit(String typeProduit) {
		Query query = em.createQuery("SELECT s FROM SpecialisationProduit s WHERE s.typeProduit.intitule = :typeProduit").setParameter("typeProduit", typeProduit);
		return query.getResultList();
	}

}
