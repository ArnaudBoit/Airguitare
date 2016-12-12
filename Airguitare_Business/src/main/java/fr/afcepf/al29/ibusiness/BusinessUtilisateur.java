package fr.afcepf.al29.ibusiness;

import fr.afcepf.al29.airguitare.api.IDAOAdresse;
import fr.afcepf.al29.airguitare.api.IDAOClient;
import fr.afcepf.al29.airguitare.api.IDAOPays;
import fr.afcepf.al29.airguitare.api.IDAOVille;
import fr.afcepf.al29.business.IBusinessUtilisateur;

/**
 * 
 */
public class BusinessUtilisateur implements IBusinessUtilisateur {

   
    /**
     * 
     */
    private IDAOAdresse DAOAdresse;

    /**
     * 
     */
    private IDAOClient DAOClient;

    /**
     * 
     */
    private IDAOVille DAOVille;
    
    private IDAOPays DAOPays;

}