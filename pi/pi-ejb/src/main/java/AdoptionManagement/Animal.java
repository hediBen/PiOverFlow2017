package persistence.AdoptionManagement;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import persistence.UserManagement.User;

/**
 * Entity implementation class for Entity: Animal
 *
 */
@Entity

public class Animal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String gender;
	private String age;
	private String type;
	private String race;
	private String departement;
	private boolean vaccinated;
	private boolean sterilized;
	private String place;
	private String image ;
	
	@OneToOne(mappedBy = "animal", fetch = FetchType.EAGER)
	private AdoptionOffer adoptionOffer ;
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the agent
	 */
	public User getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(User agent) {
		this.agent = agent;
	}

	@ManyToOne
	private User agent;
	

	;

	private static final long serialVersionUID = 1L;

	public Animal(int id, String name, String gender, String age, String type, String race, String departement,
			boolean vaccinated, boolean sterilized, String place ,String image) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.type = type;
		this.race = race;
		this.departement = departement;
		this.vaccinated = vaccinated;
		this.sterilized = sterilized;
		this.place = place;
		this.image = image ;
	}

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race
	 *            the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}

	/**
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * @param departement
	 *            the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * @return the vaccinated
	 */
	public boolean isVaccinated() {
		return vaccinated;
	}

	/**
	 * @param vaccinated
	 *            the vaccinated to set
	 */
	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	/**
	 * @return the sterilized
	 */
	public boolean isSterilized() {
		return sterilized;
	}

	/**
	 * @param sterilized
	 *            the sterilized to set
	 */
	public void setSterilized(boolean sterilized) {
		this.sterilized = sterilized;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", type=" + type
				+ ", race=" + race + ", departement=" + departement + ", vaccinated=" + vaccinated + ", sterilized="
				+ sterilized + ", place=" + place + ", image=" + image + ", agent=" + agent + "]";
	}

	
}
