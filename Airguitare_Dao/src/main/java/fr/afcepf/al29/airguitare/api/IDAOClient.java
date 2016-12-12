package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.Personne;

/**
 * 
 */
public interface IDAOClient {

    /**
     * @param int id 
     * @return
     */
    public Personne getClientById(int id);

    /**
     * @return
     */
    public List<Personne> getAllClient();

    /**
     * @param Personne pers 
     * @return
     */
    public Personne createNewClient(Personne pers);

    /**
     * @param Personne pers 
     * @return
     */
    public Personne udapteClient(Personne pers);

    /**
     * @param String login 
     * @param String password 
     * @return
     */
    public Personne connectClient(String login, String password);

}