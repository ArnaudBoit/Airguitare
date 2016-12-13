package fr.afcepf.al29.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import fr.afcepf.al29.airguitare.api.IDAOBlog;
import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.api.IDAOSpecialisationProduit;
import fr.afcepf.al29.airguitare.api.IDAOTypeProduit;
import fr.afcepf.al29.airguitare.api.IDAOVille;
import fr.afcepf.al29.airguitare.entities.ArticleBlog;
import fr.afcepf.al29.airguitare.entities.CommentaireBlog;
import fr.afcepf.al29.airguitare.entities.Pays;
import fr.afcepf.al29.airguitare.entities.Produit;
import fr.afcepf.al29.airguitare.entities.SpecialisationProduit;
import fr.afcepf.al29.airguitare.entities.ThemeArticle;
import fr.afcepf.al29.airguitare.entities.TypeProduit;
import fr.afcepf.al29.airguitare.entities.Ville;

@ManagedBean(name="ville")
@RequestScoped
public class VilleManagedBean {
	@EJB
	private IDAOVille proxy;
	@EJB
	private IDAOProduit proxyProduit;
	@EJB
	private IDAOBlog proxyBlog;
	@EJB
	private IDAOTypeProduit proxyTypeProduit;
	@EJB
	private IDAOSpecialisationProduit proxySpecialisationProduit;
	
	
	List<Pays> pays = new ArrayList<>();
	List<Ville> villes = new ArrayList<>();
	List<Produit> produits = new ArrayList<>();
	List<ArticleBlog> articles = new ArrayList<>();
	ArticleBlog article = new ArticleBlog();
	TypeProduit typeProduit = new TypeProduit();
	List<SpecialisationProduit> specialisationProduits = new ArrayList<>();
	@PostConstruct
	public void init(){
		pays = proxy.getAllPays();
		for (Pays pays2 : pays) {
			System.out.println(pays2.getNom());
		}
		
		villes= proxy.getVilleByPays(36);
		System.out.println(villes.size());
		
		produits = proxyProduit.getArticlesByType(1);
		for (Produit produit : produits) {
			System.out.println(produit.getIntitule());
		}
		
		articles = proxyBlog.GetAllArticleSortedByDate();
		for (ArticleBlog articleBlog : articles) {
			System.out.println(articleBlog.getIntitule());
		}
		
		List<ThemeArticle> themes = proxyBlog.getTheme();
		List<CommentaireBlog> coms = null;
		CommentaireBlog com = null;
		article = new ArticleBlog("Test", "Coucou le test", new Date(), themes, coms);
		proxyBlog.createNewArticleBlog(article);
		article.setDescription("modif");
		proxyBlog.updateArticleBlog(article);
		
		typeProduit = proxyTypeProduit.getTypeProduitById(1);
		
		specialisationProduits= proxySpecialisationProduit.getSpecialisationProduitByTypeProduit(typeProduit);
		for (SpecialisationProduit specialisationProduit : specialisationProduits) {
			System.out.println(specialisationProduit.getIntitule());
		}
		
		
		
	}
	
	public String removeArticle() {
		proxyBlog.removeArticleBlog(article);
		return null;
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
