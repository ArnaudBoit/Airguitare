package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al29.airguitare.api.IDAOPays;
import fr.afcepf.al29.airguitare.entities.Pays;

@Stateless
public class DAOPays implements IDAOPays {


	@PersistenceContext(unitName = "Airguitare_Dao")
	EntityManager em;
	
	public List<Pays> getAll(){
		return em.createQuery("SELECT p FROM Pays p").getResultList();
	}
	
}
