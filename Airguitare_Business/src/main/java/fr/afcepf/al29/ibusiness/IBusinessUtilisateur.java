package fr.afcepf.al29.ibusiness;

import java.util.List;

import fr.afcepf.al29.airguitare.dto.DTOPersonne;
import fr.afcepf.al29.airguitare.entities.Personne;

public interface IBusinessUtilisateur {

	
	  /**
     * @param int id 
     * @return
     */
    public DTOPersonne getClientById(int id);

    /**
     * @return
     */
    public List<DTOPersonne> getAllClient();

    /**
     * @param Personne pers 
     * @return
     */
    public DTOPersonne createNewClient(Personne pers);

    /**
     * @param Personne pers 
     * @return
     */
    public DTOPersonne udapteClient(Personne pers);

    /**
     * @param String login 
     * @param String password 
     * @return
     */
    public DTOPersonne connectClient(String login, String password);

}
