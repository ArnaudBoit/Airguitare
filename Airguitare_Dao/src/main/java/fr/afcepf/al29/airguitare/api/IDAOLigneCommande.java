package fr.afcepf.al29.airguitare.api;

import javax.ejb.Local;

import fr.afcepf.al29.airguitare.entities.LigneCommande;

@Local
public interface IDAOLigneCommande {

	LigneCommande addLigne(LigneCommande newligne);
}
