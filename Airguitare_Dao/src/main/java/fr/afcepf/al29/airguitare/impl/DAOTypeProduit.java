package fr.afcepf.al29.airguitare.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOTypeProduit;
import fr.afcepf.al29.airguitare.entities.TypeProduit;

@Stateless
public class DAOTypeProduit implements IDAOTypeProduit {

	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;
	
	@Override
	public TypeProduit getTypeProduitById(int idTypeProduit) {
		Query query = em.createQuery("SELECT t FROM TypeProduit t WHERE t.id = :idTypeProduit", TypeProduit.class).setParameter("idTypeProduit", idTypeProduit);
		return (TypeProduit) query.getSingleResult();
	}

}
