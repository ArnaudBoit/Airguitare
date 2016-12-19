package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.entities.Personne;
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
	public List<Produit> getArticlesByType(String typeProduit) {
		Query query = em.createQuery("FROM Produit WHERE specialisationProduit.typeProduit.intitule = :typeProduit").setParameter("typeProduit", typeProduit);
		List<Produit> liste = query.getResultList();		
		return liste;
	}

	@Override
	public List<Produit> getAllArticleBySpecialisation(String specialisation) {
		Query query = em.createQuery("FROM Produit  WHERE specialisationProduit.intitule = :specialisation").setParameter("specialisation", specialisation);
		return query.getResultList();
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
		Query query = em.createQuery("FROM Produit WHERE id :idProduit").setParameter("idProduit", idProduit);
		List<Produit> produits = query.getResultList();
		if(!produits.isEmpty()) {
			return produits.get(0);
		}
		return null;
	}

	@Override
	public List<Produit> getProduitByPrix(double prix) {
		Query query = em.createQuery("FROM Produit WHERE prix < :prix").setParameter("prix", prix);
		return query.getResultList();
	}

	@Override
	public List<Produit> getAll() {
		Query query = em.createQuery("FROM Produit");
		return query.getResultList();
	}

}