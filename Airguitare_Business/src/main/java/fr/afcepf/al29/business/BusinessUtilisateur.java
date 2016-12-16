package fr.afcepf.al29.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al29.airguitare.api.IDAOClient;
import fr.afcepf.al29.airguitare.dto.DTOPersonne;
import fr.afcepf.al29.airguitare.entities.Personne;
import fr.afcepf.al29.ibusiness.IBusinessUtilisateur;

@Stateless
public class BusinessUtilisateur implements IBusinessUtilisateur {
	@EJB
	private IDAOClient daoClient;
	
	@Override
	public DTOPersonne getClientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTOPersonne> getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTOPersonne createNewClient(Personne pers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTOPersonne udapteClient(Personne pers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTOPersonne connectClient(String login, String password) {
		
		Personne pers = daoClient.connectClient(login, password);
		DTOPersonne persDTO = new DTOPersonne();
		if(pers!=null){
		return persDTO = new DTOPersonne(pers, false);
		}else {
		return null; 
		}
	}



	
	
}
