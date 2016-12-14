package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOClient;
import fr.afcepf.al29.airguitare.entities.Personne;

/**
 * 
 */
@Stateless
public class DAOClient implements IDAOClient {
	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;

	@Override
	public Personne getClientById(int id) {
		// TODO Auto-generated method stub
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
		
		Personne pers = (Personne) query.getSingleResult();
		if(query != null) {
			return pers;
		}
		return null;
	}

    

}