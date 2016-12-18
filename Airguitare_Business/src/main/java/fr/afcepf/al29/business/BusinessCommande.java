package fr.afcepf.al29.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al29.airguitare.api.IDAOCommande;
import fr.afcepf.al29.airguitare.api.IDAOLigneCommande;
import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.dto.DTOCommande;
import fr.afcepf.al29.airguitare.dto.DTOLigneCommande;
import fr.afcepf.al29.airguitare.dto.DTOProduit;
import fr.afcepf.al29.airguitare.entities.Commande;
import fr.afcepf.al29.airguitare.entities.LigneCommande;
import fr.afcepf.al29.ibusiness.IBusinessCommande;

/**
 * 
 */@Stateless
 public class BusinessCommande implements IBusinessCommande {


	 /**
	  * 
	  */@EJB
	  private IDAOCommande DAOCommande;

	  /**
	   * 
	   */
	  private IDAOProduit DAOProduit;

	  private IDAOLigneCommande DAOLigneCommande;

	  @Override
	  public List<DTOCommande> getCommandesByUser(int idUser) {
		  List<DTOCommande> commandesDTO = new ArrayList<>();
		  List<Commande> commandes = DAOCommande.getCommandeByClient(idUser);
		  if(commandes!=null){
			  for (Commande commande :commandes ){
				  DTOCommande dto = new DTOCommande(commande, false);
				  commandesDTO.add(dto);
			  }
			  return commandesDTO;
		  }else{
			  return null;
		  }
	  }

	  @Override
	  public double getPrixByCommande(int idCommande) {
		  double prix =0;
		  List<LigneCommande>lignes  =	DAOCommande.getLignesByCommande(idCommande);
		  
		  List<DTOLigneCommande> dtolignes = new ArrayList<>();
		  if(lignes !=null) {
			  for (LigneCommande ligneCommande : lignes) {
				  DTOLigneCommande dto = new DTOLigneCommande(ligneCommande, false);
				 LigneCommande ligne =  DAOCommande.getLigneById(dto.getId());
				 prix += ligne.getQuantite() * ligne.getProduit().getPrix();
			  }
			
		  }
		  return prix;
	  }

 }