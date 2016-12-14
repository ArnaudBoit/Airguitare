package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="paypal")
public class Paypal implements Serializable{

    

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    /**
     * 
     */
    private String intitule;

    /**
     * 
     */
    private String mail;

    /**
     * 
     */
    @OneToOne
    private ModePaiement modePaiement;
    
    /**
     * Default constructor
     */
    public Paypal() {
    }

	public Paypal(int id, String intitule, String mail, ModePaiement modePaiement) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.mail = mail;
		this.modePaiement = modePaiement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((modePaiement == null) ? 0 : modePaiement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paypal other = (Paypal) obj;
		if (id != other.id)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (modePaiement == null) {
			if (other.modePaiement != null)
				return false;
		} else if (!modePaiement.equals(other.modePaiement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paypal [id=" + id + ", intitule=" + intitule + ", mail=" + mail + ", modePaiement=" + modePaiement
				+ "]";
	}
    
    

}