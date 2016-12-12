package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.AvisClient;
import fr.afcepf.al29.airguitare.entities.Personne;

/**
 * 
 */
public interface IDAOAvisClient {

    /**
     * @param Personneclient 
     * @param AvisClient avis 
     * @param int idProduit 
     * @return
     */
    public void createNewAvisClient(Personne client, AvisClient avis, int idProduit);

    /**
     * @param int idAvisClient 
     * @return
     */
    public void removeAvisClient(int idAvisClient);

    /**
     * @param int idClient 
     * @return
     */
    public List<AvisClient> getAllAvisByClient(int idClient);

}