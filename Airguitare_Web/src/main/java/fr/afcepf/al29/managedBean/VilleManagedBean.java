package fr.afcepf.al29.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import fr.afcepf.al29.airguitare.api.IDAOBlog;
import fr.afcepf.al29.airguitare.api.IDAOCB;
import fr.afcepf.al29.airguitare.api.IDAOClient;
import fr.afcepf.al29.airguitare.api.IDAOMarque;
import fr.afcepf.al29.airguitare.api.IDAOPaypal;
import fr.afcepf.al29.airguitare.api.IDAOProduit;
import fr.afcepf.al29.airguitare.api.IDAOSpecialisationProduit;
import fr.afcepf.al29.airguitare.api.IDAOVille;
import fr.afcepf.al29.airguitare.entities.CB;
import fr.afcepf.al29.airguitare.entities.Marque;
import fr.afcepf.al29.airguitare.entities.Paypal;
import fr.afcepf.al29.airguitare.entities.Pays;
import fr.afcepf.al29.airguitare.entities.Personne;
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
	@EJB
	private IDAOPaypal proxyPaypal;
	@EJB
	private IDAOCB proxyCB;
	@EJB
	private IDAOMarque proxyMarque;
	@EJB
	private IDAOClient proxyClient;
	@EJB
	IDAOBlog proxyBlog;
	
	String login;
	String password;
	List<Pays> pays = new ArrayList<>();
	List<Ville> villes = new ArrayList<>();
	List<Produit> produits = new ArrayList<>();
	List<Marque> marques = new ArrayList<>();
	Paypal paypal;
	List<CB> cb = new ArrayList<>();
	Personne pers = new Personne();
	@PostConstruct
	public void init(){
		pays = proxy.getAllPays();
		for (Pays pays2 : pays) {
			System.out.println(pays2.getNom());
		}
		
		villes= proxy.getVilleByPays(36);
		System.out.println(villes.size());
		
		produits = proxyProduit.getArticlesByType("guitare");
		
		for (Produit produit : produits) {
			
			System.out.println(produit.getIntitule() + " " + produit.getPrix());
		}
		
		produits = proxyProduit.getAllArticleBySpecialisation("guitares classiques");
		
		for (Produit produit : produits) {
			
			System.out.println(produit.getIntitule() + " " + produit.getPrix());
		}
		
		paypal = proxyPaypal.getPaypalByCLient(10);
		System.out.println(paypal.toString());
		cb = proxyCB.getCBByClient(4);
		for (CB cb2 : cb) {
			System.out.println(cb2.toString());
		}
		marques = proxyMarque.getAll();
		for (Marque marque : marques) {
			System.out.println(marque.getIntitule());
		}
		
		produits = proxyProduit.getProduitByPrix(2000);
		for (Produit produit : produits) {
			
			System.out.println(produit.getIntitule() + " � " + produit.getPrix() + "�");
			
		}
		
		marques = proxyMarque.getMarqueBySpecialisationProduit("guitares classiques");
		System.out.println("les marques tri�es");
		for (Marque marque : marques) {
			System.out.println(marque.getIntitule());
		}
		
		System.out.println("nb de commentaires"+proxyBlog.nombreCommentaireByArticle(6));
		
		//proxyClient.connectClient("dfgfdg", "sfddsf");
	}
	
	public String connection(){
		
		pers = proxyClient.connectClient(login, password);
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

	public IDAOProduit getProxyProduit() {
		return proxyProduit;
	}

	public void setProxyProduit(IDAOProduit proxyProduit) {
		this.proxyProduit = proxyProduit;
	}

	public IDAOSpecialisationProduit getProxySpecialisation() {
		return proxySpecialisation;
	}

	public void setProxySpecialisation(IDAOSpecialisationProduit proxySpecialisation) {
		this.proxySpecialisation = proxySpecialisation;
	}

	public IDAOPaypal getProxyPaypal() {
		return proxyPaypal;
	}

	public void setProxyPaypal(IDAOPaypal proxyPaypal) {
		this.proxyPaypal = proxyPaypal;
	}

	public IDAOCB getProxyCB() {
		return proxyCB;
	}

	public void setProxyCB(IDAOCB proxyCB) {
		this.proxyCB = proxyCB;
	}

	public IDAOMarque getProxyMarque() {
		return proxyMarque;
	}

	public void setProxyMarque(IDAOMarque proxyMarque) {
		this.proxyMarque = proxyMarque;
	}

	public IDAOClient getProxyClient() {
		return proxyClient;
	}

	public void setProxyClient(IDAOClient proxyClient) {
		this.proxyClient = proxyClient;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public List<Marque> getMarques() {
		return marques;
	}

	public void setMarques(List<Marque> marques) {
		this.marques = marques;
	}

	public Paypal getPaypal() {
		return paypal;
	}

	public void setPaypal(Paypal paypal) {
		this.paypal = paypal;
	}

	public List<CB> getCb() {
		return cb;
	}

	public void setCb(List<CB> cb) {
		this.cb = cb;
	}

	public Personne getPers() {
		return pers;
	}

	public void setPers(Personne pers) {
		this.pers = pers;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
