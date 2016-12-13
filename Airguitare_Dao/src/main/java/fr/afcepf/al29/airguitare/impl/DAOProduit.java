package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.entities.Produit;
import fr.afcepf.al29.airguitare.entities.SpecialisationProduit;
import fr.afcepf.al29.airguitare.entities.TypeProduit;

/**
 * 
 */
@Stateless
public class DAOProduit implements IDAOProduit {

	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;
	
	@Override
	public List<Produit> getArticlesByType(int idType) {
		Query query = em.createQuery("SELECT p FROM Produit p WHERE p.specialisationProduit.id = :idType").setParameter("idType", idType);
		return query.getResultList();
	}

	@Override
	public List<Produit> getAllArticleBySpecialisation(SpecialisationProduit specialisation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit addProduit(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit removeProduit(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> getArticlesOrderBy(TypeProduit typeProduit, String filtre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getArticleById(int idProduit) {
		// TODO Auto-generated method stub
		return null;
	}

   

}