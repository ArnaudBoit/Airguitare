package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOAvisClient;
import fr.afcepf.al29.airguitare.entities.AvisClient;
import fr.afcepf.al29.airguitare.entities.Personne;

/**
 * 
 */
@Stateless
public class DAOAvisClient implements IDAOAvisClient {

	@PersistenceContext(unitName="Airguitare_Dao")
    EntityManager em;

	@Override
	public void createNewAvisClient(AvisClient avis) {
		em.persist(avis);
		
	}

	@Override
	public void removeAvisClient(AvisClient avisClient) {
		em.persist(avisClient);
		
	}

	@Override
	public List<AvisClient> getAllAvisByClient(int idClient) {
		Query query = em.createQuery("SELECT a FROM AvisClient WHERE a.personne.id = :idClient", AvisClient.class).setParameter("idClient", idClient);
		return query.getResultList();
	}}