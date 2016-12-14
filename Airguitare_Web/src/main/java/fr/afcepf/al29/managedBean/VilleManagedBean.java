package fr.afcepf.al29.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.api.IDAOSpecialisationProduit;
import fr.afcepf.al29.airguitare.api.IDAOVille;
import fr.afcepf.al29.airguitare.entities.Pays;
import fr.afcepf.al29.airguitare.entities.Produit;
import fr.afcepf.al29.airguitare.entities.Ville;

@ManagedBean(name="ville")
@RequestScoped
public class VilleManagedBean {
	@EJB
	private IDAOVille proxy;
	@EJB
	private IDAOProduit proxyProduit;
	@EJB
	private IDAOSpecialisationProduit proxySpecialisation;
	
	List<Pays> pays = new ArrayList<>();
	List<Ville> villes = new ArrayList<>();
	List<Produit> produits = new ArrayList<>();
	@PostConstruct
	public void init(){
		pays = proxy.getAllPays();
		for (Pays pays2 : pays) {
			System.out.println(pays2.getNom());
		}
		
		villes= proxy.getVilleByPays(36);
		System.out.println(villes.size());
		
		produits = proxyProduit.getArticlesByType(2);
		for (Produit produit : produits) {
			System.out.println(produit.getIntitule());
		}
		
	
	}

	public IDAOVille getProxy() {
		return proxy;
	}

	public void setProxy(IDAOVille proxy) {
		this.proxy = proxy;
	}

	public List<Pays> getPays() {
		return pays;
	}

	public void setPays(List<Pays> pays) {
		this.pays = pays;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}
	
	
}
