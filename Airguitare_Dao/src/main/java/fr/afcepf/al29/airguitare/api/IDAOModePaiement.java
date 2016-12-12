package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.CB;
import fr.afcepf.al29.airguitare.entities.ModePaiement;
import fr.afcepf.al29.airguitare.entities.Paypal;

/**
 * 
 */
public interface IDAOModePaiement {

    /**
     * @param int idPersonne 
     * @return
     */
    public List<ModePaiement> getAllByPersonne(int idPersonne);

    /**
     * @param int idPersonne 
     * @return
     */
    public Paypal getPaypalByPersonne(int idPersonne);

    /**
     * @param int idPersonne 
     * @return
     */
    public List<CB> getCBByPersonne(int idPersonne);

}