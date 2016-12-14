package fr.afcepf.al29.airguitare.api;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al29.airguitare.entities.ThemeArticle;

@Local
public interface IDAOThemeArticle {

	List<ThemeArticle> getTheme();
}
