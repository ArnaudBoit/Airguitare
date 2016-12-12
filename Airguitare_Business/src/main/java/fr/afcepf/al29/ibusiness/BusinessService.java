package fr.afcepf.al29.ibusiness;

import fr.afcepf.al29.airguitare.api.IDAOBilleterie;
import fr.afcepf.al29.airguitare.api.IDAOFormation;
import fr.afcepf.al29.airguitare.api.IDAOFormule;
import fr.afcepf.al29.business.IBusinessService;

public class BusinessService implements IBusinessService {
	
	private IDAOBilleterie DAOBilleterie;
	
	private IDAOFormule DAOFormule;
	
	private IDAOFormation DAOFormation;

}
