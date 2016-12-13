package test;

import java.util.List;

import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.entities.Produit;
import fr.afcepf.al29.airguitare.entities.TypeProduit;
import fr.afcepf.al29.airguitare.impl.DAOProduit;

public class Test {
	//@org.junit.Test
	public void produit(){
		IDAOProduit dao = new DAOProduit();
		List<Produit> produits = dao.getArticlesByType(1);
		for (Produit produit : produits) {
			System.out.println(produit.getIntitule());
		}
	}

}
