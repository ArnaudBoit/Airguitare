package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOClient;
import fr.afcepf.al29.airguitare.entities.Personne;
import fr.afcepf.al29.airguitare.entities.Produit;

/**
 * 
 */
@Stateless
public class DAOClient implements IDAOClient {
	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;

	@Override
	public Personne getClientById(int id) {
			Query query = em.createQuery("FROM Personne WHERE id =:idPersonne").setParameter("idPersonne", id);
			List<Personne> personnes = query.getResultList();
			if(!personnes.isEmpty()) {
				return personnes.get(0);
			}
			return null;
		}

	@Override
	public List<Personne> getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne createNewClient(Personne pers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne udapteClient(Personne pers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne connectClient(String login, String password) {
		Query query = em.createQuery("FROM Personne WHERE adresseMail = :login and password = :password",Personne.class).setParameter("login", login).setParameter("password", password);
		List<Personne> personnes = query.getResultList();
		if(!personnes.isEmpty()) {
			return personnes.get(0);
		}
		return null;
	}

    

}