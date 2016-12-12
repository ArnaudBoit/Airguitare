package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.ModeLivraison;

/**
 * 
 */
public interface IDAOModeLivraison {

    /**
     * @return
     */
    public List<ModeLivraison> getAll();

    /**
     * @param int idModeLivraison 
     * @return
     */
    public ModeLivraison getModeLivraisonById(int idModeLivraison);

}