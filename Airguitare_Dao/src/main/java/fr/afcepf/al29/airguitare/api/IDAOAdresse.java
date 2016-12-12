package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.Adresse;

/**
 * 
 */
public interface IDAOAdresse {

    /**
     * @param int  idClient 
     * @return
     */
    public List<Adresse> getAllAdresseByClient(int  idClient);

    /**
     * @param Adresse adresse 
     * @return
     */
    public Adresse updateAdresse(Adresse adresse);

    /**
     * @param Adresse adresse 
     * @return
     */
    public Adresse createNewAdresse(Adresse adresse);

}