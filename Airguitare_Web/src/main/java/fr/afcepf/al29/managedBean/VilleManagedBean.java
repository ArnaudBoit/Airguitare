package fr.afcepf.al29.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import fr.afcepf.al29.airguitare.api.IDAOVille;
import fr.afcepf.al29.airguitare.entities.Pays;

@ManagedBean(name="ville")
@RequestScoped
public class VilleManagedBean {
	@EJB
	private IDAOVille proxy;
	
	List<Pays> pays = new ArrayList<>();
	
	@PostConstruct
	public void init(){
		pays = proxy.getAllPays();
		for (Pays pays2 : pays) {
			System.out.println(pays2.getNom());
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
	
	
}
