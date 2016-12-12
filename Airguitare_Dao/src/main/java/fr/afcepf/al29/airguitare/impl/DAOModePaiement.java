package fr.afcepf.al29.airguitare.impl;

import java.util.List;

import fr.afcepf.al29.airguitare.api.IDAOModePaiement;
import fr.afcepf.al29.airguitare.entities.CB;
import fr.afcepf.al29.airguitare.entities.ModePaiement;
import fr.afcepf.al29.airguitare.entities.Paypal;

/**
 * 
 */
public class DAOModePaiement implements IDAOModePaiement {

	@Override
	public List<ModePaiement> getAllByPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paypal getPaypalByPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CB> getCBByPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return null;
	}

    

}