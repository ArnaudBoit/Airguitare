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
    public void createNewAvisClient(AvisClient avis);

    /**
     * @param int idAvisClient 
     * @return
     */
    public void removeAvisClient(AvisClient avisClient);

    /**
     * @param int idClient 
     * @return
     */
    public List<AvisClient> getAllAvisByClient(int idClient);

}