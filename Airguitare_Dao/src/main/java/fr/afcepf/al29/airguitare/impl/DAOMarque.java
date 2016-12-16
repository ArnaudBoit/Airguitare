package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOMarque;
import fr.afcepf.al29.airguitare.entities.Marque;
import fr.afcepf.al29.airguitare.entities.Produit;
@Stateless
public class DAOMarque implements IDAOMarque {

	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;
	@Override
	public List<Marque> getAll() {
		Query query = em.createQuery("FROM Marque");
		return query.getResultList();
	}
	
	@Override
	public List<Marque> getMarqueBySpecialisationProduit(String specialisationProduit){
		Query query = em.createQuery("SELECT m FROM Marque m INNER JOIN m.produits p WHERE p.specialisationProduit.intitule = :specialisationProduit").setParameter("specialisationProduit", specialisationProduit);
		return query.getResultList();
	}

	@Override
	public List<Marque> getMarqueById(int id) {

		Query query = em.createQuery("SELECT m FROM Marque m WHERE m.id = :mid").setParameter("mid", id);
		return query.getResultList();
	}
	
	

}
