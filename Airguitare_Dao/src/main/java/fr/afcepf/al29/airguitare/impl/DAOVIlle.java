package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOVille;
import fr.afcepf.al29.airguitare.entities.Pays;
import fr.afcepf.al29.airguitare.entities.Ville;

/**
 * 
 */
@Stateless
public class DAOVIlle implements IDAOVille {
	
	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;
	
	@Override
	public List<Ville> getVilleByPays(int idPays) {
		//return em.createQuery("SELECT v FROM Ville v WHERE v.pays.id = :pays_id",Ville.class).setParameter("pays_id", idPays).getResultList();
		return null;
	}

	@Override
	public List<Pays> getAllPays() {
		Query query = em.createQuery("SELECT p FROM Pays p");
    	return query.getResultList();
		
	}

	@Override
	public Ville addVille(Ville ville) {
		// TODO Auto-generated method stub
		return null;
	}

   

}