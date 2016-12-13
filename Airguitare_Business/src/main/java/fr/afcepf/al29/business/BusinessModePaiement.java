package fr.afcepf.al29.business;

import fr.afcepf.al29.airguitare.api.IDAOCB;
import fr.afcepf.al29.airguitare.api.IDAOModePaiement;
import fr.afcepf.al29.airguitare.api.IDAOPaypal;
import fr.afcepf.al29.ibusiness.IBusinessModePaiment;

/**
 * 
 */
public class BusinessModePaiement implements IBusinessModePaiment {

    /**
     * 
     */
    private IDAOModePaiement DAOModePaiement;
    
    private IDAOCB DAOCB;
    
    private IDAOPaypal DAOPaypal;

}