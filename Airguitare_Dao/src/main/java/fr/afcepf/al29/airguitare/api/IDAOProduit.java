package fr.afcepf.al29.airguitare.api;

import java.util.List;

import fr.afcepf.al29.airguitare.entities.Produit;
import fr.afcepf.al29.airguitare.entities.SpecialisationProduit;
import fr.afcepf.al29.airguitare.entities.TypeProduit;

/**
 * 
 */
public interface IDAOProduit {

    /**
     * @param TypeProduit type 
     * @return
     */
    public List<Produit> getArticlesByType(TypeProduit type);

    /**
     * @param SpecialisationProduit 
     * @return
     */
    public List<Produit> getAllArticleBySpecialisation(SpecialisationProduit specialisation);

    /**
     * @param Produit produit 
     * @return
     */
    public Produit addProduit(Produit produit);

    /**
     * @param Produit produit 
     * @return
     */
    public Produit updateProduit(Produit produit);

    /**
     * @param Produit produit 
     * @return
     */
    public Produit removeProduit(Produit produit);

    /**
     * @param TypeProduit typeProduit 
     * @param String filtre 
     * @return
     */
    public List<Produit> getArticlesOrderBy(TypeProduit typeProduit, String filtre);

    /**
     * @param int idProduit 
     * @return
     */
    public Produit getArticleById(int idProduit);

}