package persistence.AdoptionManagement;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdoptionOffer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String category;
	private String etat ;

	 @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE} ,orphanRemoval=true)
private Animal animal ;
	
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * @return the animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * @param animal the animal to set
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public AdoptionOffer() {
		super();
	}

	

	public AdoptionOffer(int id, String description, String category, String etat, Animal animal) {
		super();
		this.id = id;
		this.description = description;
		this.category = category;
		this.etat = etat;
		this.animal = animal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdoptionOffer [id=" + id + ", description=" + description + ", category=" + category + ", etat=" + etat
				+ ", animal=" + animal + "]";
	}

	



}
