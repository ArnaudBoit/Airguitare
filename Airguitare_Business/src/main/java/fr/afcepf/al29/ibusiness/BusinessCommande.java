package fr.afcepf.al29.ibusiness;

import fr.afcepf.al29.airguitare.api.IDAOCommande;
import fr.afcepf.al29.airguitare.api.IDAOLigneCommande;
import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.business.IBusinessCommande;

/**
 * 
 */
public class BusinessCommande implements IBusinessCommande {


    /**
     * 
     */
    private IDAOCommande DAOCommande;

    /**
     * 
     */
    private IDAOProduit DAOProduit;
    
    private IDAOLigneCommande DAOLigneCommande;

}