package fr.afcepf.al29.airguitare.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al29.airguitare.api.IDAOLigneCommande;
import fr.afcepf.al29.airguitare.entities.LigneCommande;

@Stateless
public class DAOLigneCommande implements IDAOLigneCommande {

	@PersistenceContext(unitName = "Airguitare_Dao")
	EntityManager em;
	
	@Override
	public LigneCommande addLigne(LigneCommande newligne) {
		em.persist(newligne);
		return newligne;
	}

}
