package fr.afcepf.al29.airguitare.api;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al29.airguitare.entities.Commande;

/**
 * 
 */
@Local
public interface IDAOCommande {

    /**
     * @param int idClient 
     * @return
     */
    public List<Commande> getCommandeByClient(int idClient);

    /**
     * @param int numero 
     * @return
     */
    public Commande getCommandeById(int numero);

    /**
     * @param Commande commande 
     * @return
     */
    public Commande addCommande(Commande commande);

}