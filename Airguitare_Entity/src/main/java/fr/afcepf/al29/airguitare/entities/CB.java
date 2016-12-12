package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="cb")
public class CB implements Serializable{

   

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
    private String identite;

    /**
     * 
     */
    private String intitule;

    /**
     * 
     */
    private String numero;

    /**
     * 
     */
    private Date dateExpiration;

    /**
     * 
     */
    private int cle;

    /**
     * 
     */
    @ManyToOne
    private ModePaiement modePaiement;
    
    /**
     * Default constructor
     */
    public CB() {
    }

	public CB(int id, String identite, String intitule, String numero, Date dateExpiration, int cle,
			ModePaiement modePaiement) {
		super();
		this.id = id;
		this.identite = identite;
		this.intitule = intitule;
		this.numero = numero;
		this.dateExpiration = dateExpiration;
		this.cle = cle;
		this.modePaiement = modePaiement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentite() {
		return identite;
	}

	public void setIdentite(String identite) {
		this.identite = identite;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public int getCle() {
		return cle;
	}

	public void setCle(int cle) {
		this.cle = cle;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}
    
    

}