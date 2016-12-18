package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOCommande;
import fr.afcepf.al29.airguitare.entities.Commande;
import fr.afcepf.al29.airguitare.entities.Personne;

/**
 * 
 */
@Stateless
public class DAOCommande implements IDAOCommande {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Commande> getCommandeByClient(int idClient) {
		Query query = em.createQuery("FROM Commande WHERE personne.id = :idClient", Commande.class).setParameter("idClient", idClient);
		return query.getResultList();
		
	}

	@Override
	public Commande getCommandeById(int numero) {
		Query query = em.createQuery("FROM Commande WHERE id = :numero").setParameter("numero", numero);
		List<Commande> commandes = query.getResultList();
		if(!commandes.isEmpty()){
			return commandes.get(0);
		}
		return null;
	}

	@Override
	public Commande addCommande(Commande commande) {

		em.persist(commande);
		return commande;
	}



}