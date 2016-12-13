package fr.afcepf.al29.airguitare.api;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al29.airguitare.entities.Pays;

@Local
public interface IDAOPays {

	public List<Pays> getAll();
}
