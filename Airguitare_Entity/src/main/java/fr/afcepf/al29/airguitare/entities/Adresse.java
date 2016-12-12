package fr.afcepf.al29.airguitare.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="adresse")
public class Adresse implements Serializable{
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
	//
    private int numero;

    /**
     * 
     */
    private String rue;

    /**
     * 
     */
    @Column(nullable=true)
    private String complement;

    /**
     * 
     */
    @ManyToMany(mappedBy="adresses")
    @Column(nullable = true)
    private Set<Personne> personnes;

    /**
     * 
     */
    @ManyToOne
    private Ville ville;
    
    /**
     * Default constructor
     */
    public Adresse() {
    }
    
    

    public Adresse(int id, int numero, String rue, String complement, Set<Personne> personnes, Ville ville) {
		super();
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.complement = complement;
		this.personnes = personnes;
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Set<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
    
    

}