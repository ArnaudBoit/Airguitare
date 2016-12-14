package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al29.airguitare.api.IDAOThemeArticle;
import fr.afcepf.al29.airguitare.entities.ThemeArticle;

@Stateless
public class DAOThemeArticle implements IDAOThemeArticle {

	@PersistenceContext(unitName="Airguitare_Dao")
	EntityManager em;
	@Override
	public List<ThemeArticle> getTheme() {
		Query query = em.createQuery("SELECT t FROM ThemeArticle t", ThemeArticle.class);
		return query.getResultList();
	}

}
